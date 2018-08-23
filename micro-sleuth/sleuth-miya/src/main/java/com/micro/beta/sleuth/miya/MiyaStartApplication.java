/*
 * @(#)MiyaStartApplication.java      2018/8/23
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.sleuth.miya;

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
public class MiyaStartApplication {
    public static void main(String[] args){
        SpringApplication.run(MiyaStartApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(MiyaStartApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/miya")
    public String info(){
        return restTemplate.getForObject("http://localhost:9001/hiEnd",String.class);
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
