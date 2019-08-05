/*
 * @(#)EnableSpringMicro.java      2019/8/5
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.annotation;

import com.micro.beta.demo.config.SpringMicroSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 功能：annotation
 *
 * @author twfx7
 * @since JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(SpringMicroSelector.class)
public @interface EnableSpringMicro {
}
