/*
 * @(#)HelloController.java      2019/1/8
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.rest;

import com.micro.beta.dubbo.consumer.GreetingConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/api/v1")
public class HelloController {
    @Autowired
    GreetingConsumer greetingConsumer;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(@RequestParam String name){
        return greetingConsumer.iGreetingService.sayHello(name);
    }
}

