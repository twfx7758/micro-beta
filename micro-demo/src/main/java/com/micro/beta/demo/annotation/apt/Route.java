package com.micro.beta.demo.annotation.apt;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {
    String value() default "";
}
