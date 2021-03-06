/*
 * @(#)GreetingServiceImpl.java      2018/7/27
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.provider.services.rpc;

import com.micro.beta.dubbo.service.interfaces.IGreetingService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
@Service(interfaceClass = IGreetingService.class, retries = 0)
@org.springframework.stereotype.Service
public class GreetingServiceImpl implements IGreetingService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
