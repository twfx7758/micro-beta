/*
 * @(#)ItemList.java      2018/9/20
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.arthas;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class ItemList {
    public void execute() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");

        List<String> list2 = new ArrayList<String>();
        list2.add("c");
        list2.add("d");

        int len = add(list, list2);
    }

    private int add(List<String> list, List<String> list2) {
        list.addAll(list2);
        return list.size();
    }
}
