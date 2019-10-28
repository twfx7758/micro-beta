/*
 * @(#)DemoApplication.java      2018/9/20
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo;

import com.micro.beta.demo.config.AppConfig;
import com.micro.beta.demo.services.MicroBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Optional;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MicroBean microBean = applicationContext.getBean(MicroBean.class);
        System.out.println(microBean.getState());

        //ArrayList<Integer> list = new ArrayList(256);
        //list.parallelStream().filter(o -> o > 30).count();
    }
}
