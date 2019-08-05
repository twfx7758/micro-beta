/*
 * @(#)MicroBean.java      2019/8/5
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.services;

/**
 * 功能：MicroBean
 *
 * @author twfx7
 * @since JDK 1.8
 */

public class MicroBean {
    private volatile int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
