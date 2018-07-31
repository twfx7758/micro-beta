/*
 * @(#)DubboConsumerApplication.java      2018/7/27
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.micro.beta.dubbo.service.interfaces.IGreetingService;

import java.io.IOException;

/**
 * 功能：订阅者main函数入口
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class DubboConsumerApplication {
    public static void main(String arg[]) throws IOException {
        ReferenceConfig<IGreetingService> referenceConfig = new ReferenceConfig<IGreetingService>();
        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig("redis://192.168.206.111:6379"));
        referenceConfig.setInterface(IGreetingService.class);
        IGreetingService greetingService = referenceConfig.get();
        System.out.println(greetingService.sayHello("world"));

        System.in.read();
    }
}
