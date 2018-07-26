/*
 * @(#)OAuth2ServerConfig.java      2018/7/26
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 功能：
 * 一、客户端的授权模式
 * 1、授权码模式（authorization code）
 * 2、简化模式（implicit）
 * 3、密码模式（resource owner password credentials）
 * 4、客户端模式（client credentials）
 *
 * @author twfx7
 * @since JDK 1.8
 */
@Configuration
public class AuthServer {
    private static final String DEMO_RESOURCE_ID = "order";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                    //配置order访问控制，必须认证过后才可以访问
                    .antMatchers("/order/**").authenticated();

        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        RedisConnectionFactory redisConnectionFactory;

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            //允许表单认证
            security.allowFormAuthenticationForClients();
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            //配置两个客户端,一个用于password认证一个用于client认证
            //如果你的系统已经有了一套用户体系，每个用户也有了一定的权限，可以采用password模式；
            // 如果仅仅是接口的对接，不考虑用户，则可以使用client模式。
            clients.inMemory()
                    /**
                     * client模式，没有用户的概念，直接与认证服务器交互，用配置中的客户端信息去申请accessToken，
                     * 客户端有自己的client_id,client_secret对应于用户的username,password，
                     * 而客户端也拥有自己的authorities，当采取client模式认证时，对应的权限也就是客户端自己的authorities。
                     * */
                    .withClient("client_1").resourceIds(DEMO_RESOURCE_ID).authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456")
                    .and()
                    /**
                     * password模式，自己本身有一套用户体系，在认证时需要带上自己的用户名和密码，以及客户端的client_id,client_secret。
                     * 此时，accessToken所包含的权限是用户本身的权限，而不是客户端的权限。
                     * */
                    .withClient("client_2").resourceIds(DEMO_RESOURCE_ID).authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager);
        }
    }
}
