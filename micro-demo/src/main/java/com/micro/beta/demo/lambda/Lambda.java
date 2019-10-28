/*
 * @(#)Lambda.java      2019/10/28
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.lambda;

import java.util.function.Consumer;

/**
 * 功能：Lambda表达式测试
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class Lambda {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        c.accept("qu wenbin Lambda Consumer");
    }
}
