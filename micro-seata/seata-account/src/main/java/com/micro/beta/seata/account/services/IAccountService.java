/*
 * @(#)IAccountService.java      2019/4/25
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.seata.account.services;

/**
 * 功能：会员业务逻辑接口
 *
 * @author twfx7
 * @since JDK 1.8
 */
public interface IAccountService {
    /**
     * 减余额
     * @param userId
     * @param money
     */
    void debit(String userId, int money);
}
