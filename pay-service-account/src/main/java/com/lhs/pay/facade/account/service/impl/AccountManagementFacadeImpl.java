package com.lhs.pay.facade.account.service.impl;

import com.lhs.pay.core.account.biz.IAccountManagementBiz;
import com.lhs.pay.facade.account.enums.AccountInitiatorEnum;
import com.lhs.pay.facade.account.enums.AccountOperationTypeEnum;
import com.lhs.pay.facade.account.enums.AccountTypeEnum;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.service.AccountManagementFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountManagementFacadeImpl
 *
 * @author longhuashen
 * @since 16/5/24
 */
@Service("accountManagementFacade")
public class AccountManagementFacadeImpl implements AccountManagementFacade {

    @Autowired
    private IAccountManagementBiz accountManagementBiz;

    @Override
    public long reBindUserNo(String accountNo, String userNo) throws AccountBizException {
        return accountManagementBiz.reBindUserNo(accountNo, userNo);
    }

    @Override
    public String buildAccountNo(AccountTypeEnum accountTypeEnum) throws AccountBizException {
        return accountManagementBiz.buildAccountNo(accountTypeEnum);
    }

    @Override
    public long createAccount(String userNo, String accountNo, int accountType) throws AccountBizException {
        return accountManagementBiz.createAccount(userNo, accountNo, accountType);
    }

    @Override
    public long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) throws AccountBizException {
        return accountManagementBiz.createPrivateAccount(userNo, accountNo, balance, securityMoney);
    }

    @Override
    public void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum initiator, String desc) throws AccountBizException {
        accountManagementBiz.changeAccountStatus(userNo, operationType, initiator, desc);
    }
}
