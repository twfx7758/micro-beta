/*
 * @(#)AuthApplication.java      2018/7/25
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * ${DESCRIPTION}
 *
 * @author twfx7
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableAuthorizationServer
public class AuthApplication {
    public static void main(String args[]) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
