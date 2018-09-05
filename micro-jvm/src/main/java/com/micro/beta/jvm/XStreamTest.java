/*
 * @(#)XStreamTest.java      2018/9/4
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.jvm;

import com.thoughtworks.xstream.XStream;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class XStreamTest {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            XStream xs = new XStream();
            xs.toString();
            xs = null;
            if (i++ % 10000 == 0) {
                System.gc();
            }
        }
    }
}
