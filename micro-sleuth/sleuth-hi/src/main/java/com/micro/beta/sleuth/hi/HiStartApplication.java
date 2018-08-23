/*
 * @(#)HiStartApplication.java      2018/8/23
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.sleuth.hi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 功能：starter
 *
 * @author twfx7
 * @since JDK 1.8
 */
@SpringBootApplication
@RestController
public class HiStartApplication {
    public static void main(String[] args){
        SpringApplication.run(HiStartApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(HiStartApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome(){
        return restTemplate.getForObject("http://localhost:9002/miya", String.class);
    }
    @RequestMapping("/hiEnd")
    public String info(){
        return "i'm service-hi hiEnd()";
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
