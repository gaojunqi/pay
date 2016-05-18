package com.lhs.pay.facade.account.service;

import com.lhs.pay.facade.account.enums.AccountInitiatorEnum;
import com.lhs.pay.facade.account.enums.AccountOperationTypeEnum;
import com.lhs.pay.facade.account.enums.AccountTypeEnum;
import com.lhs.pay.facade.account.exception.AccountBizException;

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
    long reBindUserNo(String accountNo, String userNo) throws AccountBizException;

    /**
     * 生成账户编号
     *
     * @param accountTypeEnum
     * @return
     * @throws AccountBizException
     */
    String buildAccountNo(AccountTypeEnum accountTypeEnum) throws AccountBizException;

    /**
     * 创建账户
     *
     * @param userNo
     * @param accountNo
     * @param accountType
     * @return
     * @throws AccountBizException
     */
    long createAccount(String userNo, String accountNo, int accountType) throws AccountBizException;

    /**
     * 创建内部银行虚拟账户
     *
     * @param userNo
     * @param accountNo
     * @param balance
     * @param securityMoney
     * @return
     * @throws AccountBizException
     */
    long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) throws AccountBizException;

    /**
     * 账户状态变更
     *
     * @param userNo
     * @param operationType
     * @param initiator
     * @param desc
     */
    void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc) throws AccountBizException;
}
