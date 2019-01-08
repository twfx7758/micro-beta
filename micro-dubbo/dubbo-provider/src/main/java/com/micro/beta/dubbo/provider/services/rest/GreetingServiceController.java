/*
 * @(#)GreetingServiceController.java      2019/1/8
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.provider.services.rest;

import com.micro.beta.dubbo.service.interfaces.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：api接口
 *
 * @author twfx7
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/api/v1")
public class GreetingServiceController {
    @Autowired
    private IGreetingService iGreetingService;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) {
        return iGreetingService.sayHello(name);
    }
}
