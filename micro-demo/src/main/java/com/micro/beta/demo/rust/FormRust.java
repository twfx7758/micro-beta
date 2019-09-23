/*
 * @(#)FormRust.java      2019/8/13
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.rust;

import java.io.File;

/**
 * 功能：调用rust
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class FormRust {

    public static native void hello();

    public static native int sum(int a, int b);

    public static void main(String[] args) {
        File file = new File("mylib2.dll");
        System.load(file.getAbsolutePath());

        hello();

        System.out.println(sum(1, 3));
    }

}
