package com.lhs.pay.core.account.biz.impl;

import com.lhs.pay.core.account.biz.IAccountManagementBiz;
import com.lhs.pay.core.account.dao.AccountDao;
import com.lhs.pay.core.account.dao.AccountFrozenRecordDao;
import com.lhs.pay.facade.account.entity.Account;
import com.lhs.pay.facade.account.entity.AccountFrozenRecord;
import com.lhs.pay.facade.account.enums.AccountInitiatorEnum;
import com.lhs.pay.facade.account.enums.AccountOperationTypeEnum;
import com.lhs.pay.facade.account.enums.AccountStatusEnum;
import com.lhs.pay.facade.account.enums.AccountTypeEnum;
import com.lhs.pay.facade.account.exception.AccountBizException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * AccountManagementBizImpl
 *
 * @author longhuashen
 * @since 16/5/20
 */
@Component("accountManagementBiz")
@Transactional(rollbackFor = Exception.class)
public class AccountManagementBizImpl implements IAccountManagementBiz {

    private static final Log log = LogFactory.getLog(AccountManagementBizImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountFrozenRecordDao accountFrozenRecordDao;

    @Override
    public long reBindUserNo(String accountNo, String userNo) {
        Account account = accountDao.getByAccountNo(accountNo);

        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.print();
        }

        account.setUserNo(userNo);
        account.setLastTime(new Date());

        log.info("==>changeUserNo, accountNo:" + accountNo + userNo);
        return accountDao.update(account);
    }

    @Override
    public String buildAccountNo(AccountTypeEnum accountType) {
        String accountNo = accountDao.buildAccountNo("");
        log.info("===>buildAccountNo:" + accountNo);
        return accountNo;
    }

    @Override
    public long createAccount(String userNo, String accountNo, int accountType) {
        log.info("===>createAccount");

        String titleNo = "";
        if (AccountTypeEnum.CUSTOMER.getValue() == accountType) {
            titleNo = "2001";
        } else if (AccountTypeEnum.PRIVATE.getValue() == accountType) {
            titleNo = "1002";
        } else {
            titleNo = "2002";
        }

        Account account = new Account();
        account.setUserNo(userNo);
        account.setAccountType(accountType);
        account.setAccountNo(accountNo);
        account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        account.setAccountTitleNo(titleNo);

        return accountDao.insert(account);
    }

    @Override
    public long createPrivateAccount(String userNo, String accountNo, Double balance, Double securityMoney) {
        log.info("===>createPrivateAccount");

        String titleNo = "1002";

        Account account = new Account();
        account.setUserNo(userNo);
        account.setAccountNo(accountNo);
        account.setAccountType(AccountTypeEnum.PRIVATE.getValue());
        account.setStatus(AccountStatusEnum.ACTIVE.getValue());
        account.setAccountTitleNo(titleNo);
        account.setBalance(balance);
        account.setSecurityBalance(securityMoney);

        return accountDao.insert(account);
    }

    @Override
    public void changeAccountStatus(String userNo, AccountOperationTypeEnum operationType, AccountInitiatorEnum accountInitiator, String desc) {
        log.info("====>changeAccountStatus");
        log.info(String.format("===>userNo:%s, operationType:%s, initiator:%s, desc:%s", userNo, operationType.name(), accountInitiator.name(), desc));

        Account account = accountDao.getByUserNo_IsPessimist(userNo, false);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.print();
        }

        AccountFrozenRecord accountFrozenRecord = new AccountFrozenRecord();
        accountFrozenRecordDao.insert(accountFrozenRecord);
    }
}
