/*
 * @(#)IOrderService.java      2019/4/25
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.seata.order.services;

/**
 * 功能：订单业务逻辑接口
 *
 * @author twfx7
 * @since JDK 1.8
 */
public interface IOrderService {
    /**
     * 创建订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    void create(String userId, String commodityCode, int orderCount);
}
