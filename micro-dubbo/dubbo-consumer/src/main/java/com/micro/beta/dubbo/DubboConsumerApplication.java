/*
 * @(#)DubboConsumerApplication.java      2018/7/27
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.micro.beta.dubbo.consumer.GreetingConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 功能：订阅者main函数入口
 *
 * @author twfx7
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerApplication {
    public static void main(String arg[]) throws IOException {
        SpringApplication.run(DubboConsumerApplication.class, arg);
    }
}
