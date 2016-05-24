package com.lhs.pay.core.account.biz.impl;

import com.google.common.base.Strings;
import com.lhs.pay.common.exceptions.BizException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * AccountManagementBizImpl
 *
 * @author longhuashen
 * @since 16/5/20
 */
@Service("accountManagementBiz")
@Transactional(rollbackFor = Exception.class)
public class AccountManagementBizImpl implements IAccountManagementBiz {

    private static final Logger log = LoggerFactory.getLogger(AccountManagementBizImpl.class);

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
        String accountNo = accountDao.buildAccountNo(Strings.padStart(String.valueOf(accountType.getValue()), 3, '0'));
        log.info("===>buildAccountNo:" + accountNo);
        return accountNo;
    }

    @Override
    public long createAccount(String userNo, String accountNo, int accountType) {
        log.info("===>createAccount");

        String titleNo;
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
        account.setSecurityMoney(securityMoney);

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

        account.setStatus(chooseOperationType(operationType));
        AccountFrozenRecord accountFrozenRecord = new AccountFrozenRecord();
        accountFrozenRecord.setLastTime(new Date());
        accountFrozenRecord.setAccountNo(account.getAccountNo());
        accountFrozenRecord.setRemark(desc);
        accountFrozenRecord.setInitiator(accountInitiator.getValue());
        accountFrozenRecord.setOperationType(operationType.getValue());

        accountFrozenRecordDao.insert(accountFrozenRecord);
    }

    private static int chooseOperationType(AccountOperationTypeEnum operationType) {
        int value;
        switch (operationType) {
            case FREEZE_DEBIT:
                value = AccountStatusEnum.INACTIVE_FREEZE_DEBIT.getValue();
                break;
            case UNFREEZE_DEBIT:
                value = AccountStatusEnum.ACTIVE.getValue();
                break;
            case FREEZE_CREDIT:
                value = AccountStatusEnum.INACTIVE_FREEZE_DEBIT.getValue();
                break;
            case UNFREEZE_CREDIT:
                value = AccountStatusEnum.ACTIVE.getValue();
                break;
            case FREEZE_ACCOUNT:
                value = AccountStatusEnum.INACTIVE.getValue();
                break;
            case UNFREEZE_ACCOUNT:
                value = AccountStatusEnum.ACTIVE.getValue();
                break;
            case CREATE_ACCOUNT:
                value = AccountStatusEnum.ACTIVE.getValue();
                break;
            case FREEZE_FUND:
                value = AccountStatusEnum.INACTIVE.getValue();
                break;
            case UNFEEZE_FUND:
                value = AccountStatusEnum.ACTIVE.getValue();
                break;
            case CANCLE_ACCOUNT:
                value = AccountStatusEnum.CANCELLED.getValue();
                break;
            default:
                log.error("==>AccountOperationTypeEnum:", operationType);
                throw new BizException("传入的操作类型有误！");
        }
        return value;
    }
}
