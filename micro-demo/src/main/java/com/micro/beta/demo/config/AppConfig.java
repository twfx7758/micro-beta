/*
 * @(#)AppConfig.java      2019/8/5
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.config;

import com.micro.beta.demo.annotation.EnableSpringMicro;
import com.micro.beta.demo.services.MicroBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
@Configuration
@ComponentScan
@EnableSpringMicro
public class AppConfig {

    @Bean
    public MicroBean getMicroBean() {
        MicroBean microBean = new MicroBean();
        microBean.setState(1);
        return microBean;
    }

}
