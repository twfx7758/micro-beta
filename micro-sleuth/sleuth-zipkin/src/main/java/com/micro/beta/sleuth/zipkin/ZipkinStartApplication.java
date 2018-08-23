/*
 * @(#)ZipkinStartApplication.java      2018/8/23
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * 功能：启动
 *
 * @author twfx7
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinStartApplication {
    public static void main(String[] args){
        SpringApplication.run(ZipkinStartApplication.class, args);
    }
}
