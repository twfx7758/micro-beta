/*
 * @(#)IStorageService.java      2019/4/25
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.seata.storage.services;

/**
 * 功能：库存相关操作接口
 *
 * @author twfx7
 * @since JDK 1.8
 */
public interface IStorageService {
    /**
     * deduct storage count
     * @param commodityCode
     * @param count
     */
    void deduct(String commodityCode, int count);
}
