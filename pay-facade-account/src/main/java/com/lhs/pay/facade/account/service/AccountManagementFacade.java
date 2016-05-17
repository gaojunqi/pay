package com.lhs.pay.facade.account.service;

/**
 * AccountManagementFacade
 *
 * @author longhuashen
 * @since 16/5/17
 */
public interface AccountManagementFacade {


    /**
     * 重新绑定商户编号
     *
     * @param accountNo
     * @param userNo
     * @return
     */
    long reBindUserNo(String accountNo, String userNo);
}
