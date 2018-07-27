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
import com.micro.beta.dubbo.consumer.services.interfaces.IGreetingService;

/**
 * 功能：订阅者main函数入口
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class DubboConsumerApplication {
    public static void main(String arg[]){
        ReferenceConfig<IGreetingService> referenceConfig = new ReferenceConfig<IGreetingService>();
        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
        referenceConfig.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234?unicast=false"));
        referenceConfig.setInterface(IGreetingService.class);
        IGreetingService greetingService = referenceConfig.get();
        System.out.println(greetingService.sayHello("world"));
    }
}
