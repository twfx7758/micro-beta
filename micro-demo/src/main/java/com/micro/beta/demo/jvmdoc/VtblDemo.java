/*
 * @(#)VtblDemo.java      2019/8/23
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.jvmdoc;

/**
 * 功能：Java | JVM虚方法调用那些事
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class VtblDemo {

    public void run(Father father) {
        System.out.println("father");

    }

    public void run(Son1 son1) {
        System.out.println("son1");

    }

    public void run(Son2 son2) {
        System.out.println("son2");

    }

    public static void main(String[] args) {
        Son1 son1 = new Son1();
        Son2 son2 = new Son2();
        VtblDemo staticBind = new VtblDemo();
        staticBind.run(son1);
        staticBind.run(son2);

    }
}

class Father {
}

class Son1 {
}

class Son2 {
}


