/*
 * @(#)DubboProviderApplication.java      2018/7/27
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.provider.services;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDubboConfig
public class DubboProviderApplication {
    public static void main(String args[]) throws IOException {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
