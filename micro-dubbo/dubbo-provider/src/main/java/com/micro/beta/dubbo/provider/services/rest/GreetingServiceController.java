/*
 * @(#)GreetingServiceController.java      2019/1/8
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.dubbo.provider.services.rest;

import com.micro.beta.dubbo.service.interfaces.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * 功能：api接口
 *
 * @author twfx7
 * @since JDK 1.8
 */
@Service
@Path("/api/v1")
public class GreetingServiceController {
    @Autowired
    private IGreetingService iGreetingService;

    @GET
    @Path("/say")
    public String sayHello(@QueryParam("name") String name){
        return iGreetingService.sayHello(name);
    }
}
