/*
 * @(#)GreetingConsumer.java      2019/1/8
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.micro.beta.dubbo.service.interfaces.IGreetingService;
import org.springframework.stereotype.Component;

/**
 * 功能：订阅
 *
 * @author twfx7
 * @since JDK 1.8
 */
@Component
public class GreetingConsumer {
    @Reference(url = "dubbo://127.0.0.1:20880")
    public IGreetingService iGreetingService;
}
