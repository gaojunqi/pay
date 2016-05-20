package com.lhs.pay.core.account.biz;

import com.lhs.pay.facade.account.enums.AccountInitiatorEnum;
import com.lhs.pay.facade.account.enums.AccountOperationTypeEnum;
import com.lhs.pay.facade.account.enums.AccountTypeEnum;

/**
 * IAccountManagementBiz
 *
 * @author longhuashen
 * @since 16/5/20
 */
public interface IAccountManagementBiz {

    /**
     * 重新绑定商户编号
     *
     * @param accountNo
     * @param userNo
     * @return
     */
    long reBindUserNo(String accountNo, String userNo);

    /**
     * 生成账户编号(20位)
     *
     * @param accountType
     * @return
     */
    String buildAccountNo(AccountTypeEnum accountType);

    /**
     * 创建账户
     *
     * @param userNo
     * @param accountNo
     * @param accountType
     * @return
     */
    long createAccount(String userNo, String accountNo, int accountType);

    /**
     * 创建内部银行虚拟账户
     *
     * @param userNo
     * @param accountNo
     * @param balance
     * @param securityMoney
     * @return
     */
    long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney);

    /**
     * 账户状态变更操作
     *
     * @param userNo
     * @param operationType
     * @param accountInitiator
     * @param desc
     */
    void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum accountInitiator, String desc);
}
