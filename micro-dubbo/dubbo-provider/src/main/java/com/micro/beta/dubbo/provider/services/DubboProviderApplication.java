/*
 * @(#)DubboProviderApplication.java      2018/7/27
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.provider.services;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.micro.beta.dubbo.provider.services.impl.GreetingServiceImpl;
import com.micro.beta.dubbo.provider.services.interfaces.IGreetingService;

import java.io.IOException;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class DubboProviderApplication {
    public static void main(String args[]) throws IOException {
        ServiceConfig<IGreetingService> serviceConfig = new ServiceConfig<IGreetingService>();
        serviceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
        serviceConfig.setRegistry(new RegistryConfig("redis://192.168.206.122:6379"));
        serviceConfig.setInterface(IGreetingService.class);
        serviceConfig.setRef(new GreetingServiceImpl());
        serviceConfig.export();
        System.in.read();
    }
}
