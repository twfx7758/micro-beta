/*
 * @(#)SecurityConfiguration.java      2018/7/26
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * 功能：spring security配置
 *
 * @author twfx7
 * @since JDK 1.8
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return this.getUserDetailsService("mysql");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();
    }

    private UserDetailsService getUserDetailsService(String storeType) {
        UserDetailsService userDetailsService = null;
        switch (storeType) {
            case "memory":
                userDetailsService = this.storeUserDetailsInMemory();
                break;
            case "mysql":
                userDetailsService = this.storeUserDetailsInMySQL();
                break;
            default:
                userDetailsService = this.storeUserDetailsInMemory();
                break;
        }
        return userDetailsService;
    }
    //用户信息存储在内存中
    private UserDetailsService storeUserDetailsInMemory() {
        final String pwd = "123456";
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password(pwd).authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password(pwd).authorities("USER").build());
        return manager;
    }
    //用户信息存储在mysql里
    private UserDetailsService storeUserDetailsInMySQL() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource());
        return manager;
    }
    //获取mysql的数据源
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://bdlsaledbdev1.xbotech.com:3306/oauth?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("BdlDevl123!");

        return dataSource;
    }
}
