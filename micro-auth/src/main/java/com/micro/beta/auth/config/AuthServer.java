///*
// * @(#)OAuth2ServerConfig.java      2018/7/26
// *
// * 百得利集团拥有完全的版权
// * 使用者必须经过许可
// */
//package com.micro.beta.auth.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//import java.util.concurrent.TimeUnit;
//
///**
// * 功能：
// * 一、客户端的授权模式
// * 1、授权码模式（authorization code）
// * 2、简化模式（implicit）
// * 3、密码模式（resource owner password credentials）
// * 4、客户端模式（client credentials）
// * ResourceOwnerPasswordTokenGranter ==> password密码模式
// * AuthorizationCodeTokenGranter ==> authorization_code授权码模式
// * ClientCredentialsTokenGranter ==> client_credentials客户端模式
// * ImplicitTokenGranter ==> implicit简化模式
// * RefreshTokenGranter ==>refresh_token 刷新token专用
// *
// * @author twfx7
// * @since JDK 1.8
// */
//@Configuration
//public class AuthServer {
//    private static final String DEMO_RESOURCE_ID = "order";
//
//    @Configuration
//    @EnableResourceServer
//    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                    .and()
//                    .requestMatchers().anyRequest()
//                    .and()
//                    .anonymous()
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
//                    //配置order访问控制，必须认证过后才可以访问
//                    .antMatchers("/order/**").authenticated();
//
//        }
//    }
//
//    @Configuration
//    @EnableAuthorizationServer
//    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//        @Autowired
//        AuthenticationManager authenticationManager;
//
//        @Autowired
//        DataSource dataSource;
//
//        @Bean
//        public TokenStore tokenStore() {
//            return new JdbcTokenStore(dataSource);
//        }
//
//        @Bean
//        public ClientDetailsService clientDetails() {
//            return   new JdbcClientDetailsService(dataSource);
//        }
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints
//                    .tokenStore(tokenStore())
//                    .authenticationManager(authenticationManager);
//
//            //配置TokenServices参数
//            DefaultTokenServices tokenServices = new DefaultTokenServices();
//            tokenServices.setTokenStore(endpoints.getTokenStore());
//            tokenServices.setSupportRefreshToken(false);
//            tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//            tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//            tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30)); // 30天
//            endpoints.tokenServices(tokenServices);
//        }
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            clients.withClientDetails(clientDetails());
//        }
//
//        @Override
//        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//            //oauthServer.checkTokenAccess("isAuthenticated()");
//            oauthServer.checkTokenAccess("permitAll()");
//            oauthServer.allowFormAuthenticationForClients();
//        }
//    }
//}
