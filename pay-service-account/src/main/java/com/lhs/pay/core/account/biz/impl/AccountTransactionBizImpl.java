package com.lhs.pay.core.account.biz.impl;

import com.google.common.base.Strings;
import com.lhs.pay.common.constant.PublicStatus;
import com.lhs.pay.core.account.biz.IAccountTransactionBiz;
import com.lhs.pay.core.account.dao.AccountDao;
import com.lhs.pay.core.account.dao.AccountFrozenHistoryDao;
import com.lhs.pay.core.account.dao.AccountFrozenRecordDao;
import com.lhs.pay.core.account.dao.AccountHistoryDao;
import com.lhs.pay.facade.account.entity.Account;
import com.lhs.pay.facade.account.entity.AccountFrozenHistory;
import com.lhs.pay.facade.account.entity.AccountFrozenRecord;
import com.lhs.pay.facade.account.entity.AccountHistory;
import com.lhs.pay.facade.account.enums.*;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.vo.AccountTransactionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountTransactionBizImpl
 *
 * @author longhuashen
 * @since 16/5/24
 */
@Service("accountTransactionBiz")
@Transactional(rollbackFor = Exception.class)
public class AccountTransactionBizImpl implements IAccountTransactionBiz {

    private static final Logger log = LoggerFactory.getLogger(AccountTransactionBizImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountHistoryDao accountHistoryDao;

    @Autowired
    private AccountFrozenHistoryDao accountFrozenHistoryDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void execute(AccountTransactionVo accountTransactionVo) {
        if (Strings.isNullOrEmpty(accountTransactionVo.getUserNo())) {
            return;
        }

        log.info("===>execute");
        chooseOperationType(accountTransactionVo);
        log.info("===>execute");
    }

    private void chooseOperationType(AccountTransactionVo vo) {
        switch (vo.getAccountFundDirection()){
            case ADD:
                this.credit(vo.getUserNo(), vo.getAmount(), vo.getRequestNo(), vo.getTradeType(), vo.getDesc(), vo.getRiskDay(), vo.getFee());
                break;
            case SUB:
                this.debit(vo.getUserNo(), vo.getAmount(), vo.getRequestNo(), vo.getTradeType(), vo.getDesc(), vo.getFee());
                break;
            case FROZEN:
                this.frozen(vo.getUserNo(), vo.getFrezonAmount(), vo.getRequestNo(), vo.getTradeType());
                break;
            case UNFROZEN:
                this.unFrozen(vo.getUserNo(), vo.getUnFrezonAmount(), vo.getRequestNo(), vo.getTradeType());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void execute(List<AccountTransactionVo> accountTransactionVos) {
        log.info("===>execute");
        for (AccountTransactionVo vo : accountTransactionVos) {
            chooseOperationType(vo);
        }
        log.info("===>execute");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchCreditForSameAccount(List<AccountTransactionVo> accountTransactionVos) {
        if (accountTransactionVos == null || accountTransactionVos.isEmpty()) {
            return;
        }

        log.info("===>batchCreditForSameAccount");
        Account account = accountDao.getByUserNo_IsPessimist(accountTransactionVos.get(0).getUserNo(), true);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在，用户编号{%s}", accountTransactionVos.get(0).getUserNo()).print();
        }

        if (account.getStatus() == AccountStatusEnum.INACTIVE.getValue() || account.getStatus() == AccountStatusEnum.CANCELLED.getValue()) {
            throw AccountBizException.ACCOUNT_STATUS_IS_INACTIVE.newInstance("账户状态异常，用户编号{%s}, 账户状态{%s}", accountTransactionVos.get(0).getUserNo(), account.getStatus()).print();
        }

        int isAllowSett = PublicStatus.ACTIVE;
        if (account.getAccountType() == AccountTypeEnum.CUSTOMER.getValue()) {
            isAllowSett = PublicStatus.INACTIVE;
        }

        List<AccountHistory> listHistory = new ArrayList<>();
        for (AccountTransactionVo vo : accountTransactionVos) {
            if (!vo.getUserNo().equals(account.getUserNo())) {
                throw AccountBizException.BATCH_CREDIT_FOR_SAME_ACCOUNT_ERROR.print();
            }

            account.credit(vo.getAmount());
            AccountHistory accountHistory = new AccountHistory();
            accountHistory.setAmount(vo.getAmount());
            accountHistory.setIsAllowSett(isAllowSett);
            accountHistory.setFee(vo.getFee());
            accountHistory.setBalance(account.getAvailableSettAccount());
            accountHistory.setRequestNo(vo.getRequestNo());
            accountHistory.setIsCompleteSett(PublicStatus.INACTIVE);
            accountHistory.setRemark(vo.getTradeType().getDesc());
            accountHistory.setFundDirection(AccountFundDirectionEnum.ADD.getValue());
            accountHistory.setAccountNo(account.getAccountNo());
            accountHistory.setTrxType(vo.getTradeType().getValue());
            accountHistory.setRiskDay(vo.getRiskDay());
            listHistory.add(accountHistory);
        }

        accountDao.update(account);
        accountHistoryDao.insert(listHistory);

        log.info("===>batchCreditForSameAccount<====");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String credit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeType, String remark, Integer riskyDay, double fee) {
        log.info("===>credit");
        log.info("===>userNo:{}, amount:{}, requestNo:{}, tradeType:{}, remark:{}", userNo, amount, requestNo, tradeType.name(), remark);

        Account account = accountDao.getByUserNo_IsPessimist(userNo, true);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在，用户编号{%s}", userNo).print();
        }
        account.credit(amount);//加款

        int isAllowSett = PublicStatus.ACTIVE;

        if (account.getAccountType() == AccountTypeEnum.CUSTOMER.getValue()) {
            isAllowSett = PublicStatus.INACTIVE;
        }

        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setIsAllowSett(isAllowSett);
        accountHistory.setAmount(amount);
        accountHistory.setBalance(account.getAvailableBalance());
        accountHistory.setRequestNo(requestNo);
        accountHistory.setIsCompleteSett(PublicStatus.INACTIVE);
        accountHistory.setRemark(remark);
        accountHistory.setFee(fee);
        accountHistory.setFundDirection(AccountFundDirectionEnum.ADD.getValue());
        accountHistory.setAccountNo(account.getAccountNo());
        accountHistory.setTrxType(tradeType.getValue());
        accountHistory.setRiskDay(riskyDay);

        accountHistoryDao.insert(accountHistory);
        accountDao.update(account);

        log.info("===>credit<===");
        return account.getAccountTitleNo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String debit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeType, String remark, double fee) {
        log.info("===>debit");
        log.info("===>userNo:{}, amount:{}, requestNo:{}, tradeType:{}, remark:{}\n", userNo, amount, remark, tradeType.name(), remark);

        Account account = accountDao.getByUserNo_IsPessimist(userNo, true);

        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在，用户编号{%s}", userNo).print();
        }

        account.debit(amount);

        int isAllowsett = PublicStatus.ACTIVE;
        if (account.getAccountType() == AccountTypeEnum.CUSTOMER.getValue()) {
            isAllowsett = PublicStatus.INACTIVE;
        }

        if (tradeType.equals(AccountTradeTypeEnum.SETTLEMENT) || tradeType.equals(AccountTradeTypeEnum.ATM)) {
            isAllowsett = PublicStatus.INACTIVE;
        }

        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setIsAllowSett(isAllowsett);
        accountHistory.setAmount(amount);
        accountHistory.setFee(fee);
        accountHistory.setBalance(account.getAvailableBalance());
        accountHistory.setRequestNo(requestNo);
        accountHistory.setIsCompleteSett(PublicStatus.INACTIVE);
        accountHistory.setRemark(remark);
        accountHistory.setFundDirection(AccountFundDirectionEnum.SUB.getValue());
        accountHistory.setAccountNo(account.getAccountNo());
        accountHistory.setTrxType(tradeType.getValue());

        accountHistoryDao.insert(accountHistory);
        accountDao.update(account);

        log.info("===>debit<===");

        return account.getAccountTitleNo();
    }

    @Override
    public void frozen(String userNo, double frozenAmount, String requestNo, AccountTradeTypeEnum tradeType) {
        log.info("===>frozen");
        log.info("userNo:{}, frozenAmount:{}, requestNo:{}, tradeType:{}\n", userNo, frozenAmount, requestNo, tradeType.name());

        Account account = accountDao.getByUserNo_IsPessimist(userNo, true);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在，用户编号{%s}", userNo).print();
        }

        account.frozen(frozenAmount);
        int isAllowSett = PublicStatus.ACTIVE;
        if (account.getAccountType() == AccountTypeEnum.CUSTOMER.getValue()) {
            isAllowSett = PublicStatus.INACTIVE;
        }

        if (tradeType.equals(AccountTradeTypeEnum.SETTLEMENT) || tradeType.equals(AccountTradeTypeEnum.ATM)) {
            isAllowSett = PublicStatus.INACTIVE;
        }

        AccountFrozenHistory accountFrozenHistory = new AccountFrozenHistory();
        accountFrozenHistory.setAmmount(frozenAmount);
        accountFrozenHistory.setCurrentAmount(account.getUnBalance());
        accountFrozenHistory.setRequestNo(requestNo);
        accountFrozenHistory.setRemark(tradeType.getDesc() + "资金冻结");
        accountFrozenHistory.setAccountFrozenHistoryType(AccountFrozenHistoryTypeEnum.FROZEN.getValue());
        accountFrozenHistory.setAccountNo(account.getAccountNo());
        accountFrozenHistory.setTrxType(tradeType.getValue());

        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setIsAllowSett(isAllowSett);
        accountHistory.setAmount(frozenAmount);
        accountHistory.setBalance(account.getAvailableBalance());
        accountHistory.setRequestNo(requestNo);
        accountHistory.setIsCompleteSett(PublicStatus.INACTIVE);
        accountHistory.setRemark(tradeType.getDesc() + "资金冻结");
        accountHistory.setFundDirection(AccountFundDirectionEnum.SUB.getValue());
        accountHistory.setAccountNo(account.getAccountNo());
        accountHistory.setTrxType(tradeType.getValue());

        accountDao.update(account);
        accountHistoryDao.insert(accountHistory);
        accountFrozenHistoryDao.insert(accountFrozenHistory);

        log.info("===>frozen<===");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unFrozen(String userNo, double unFrozenAmount, String requestNo, AccountTradeTypeEnum tradeType) {
        log.info("===>unFrozen");
        log.info("userNo:{}, unFrozenAmount:{}, requestNo:{}, tradeType:{}\n", userNo, unFrozenAmount, requestNo, tradeType.name());

        Account account = accountDao.getByUserNo_IsPessimist(userNo, true);
        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在，用户编号{%s}", userNo).print();
        }

        account.frozen(unFrozenAmount);//资金解冻

        int isAllowSett = PublicStatus.ACTIVE;
        if (account.getAccountType() == AccountTypeEnum.CUSTOMER.getValue()) {
            isAllowSett = PublicStatus.INACTIVE;
        }

        if (tradeType.equals(AccountTradeTypeEnum.SETTLEMENT) || tradeType.equals(AccountTradeTypeEnum.ATM)) {
            isAllowSett = PublicStatus.INACTIVE;
        }

        AccountFrozenHistory accountFrozenHistory = new AccountFrozenHistory();
        accountFrozenHistory.setAmmount(unFrozenAmount);
        accountFrozenHistory.setCurrentAmount(account.getUnBalance());
        accountFrozenHistory.setRequestNo(requestNo);
        accountFrozenHistory.setRemark(tradeType.getDesc() + "资金解冻");
        accountFrozenHistory.setAccountFrozenHistoryType(AccountFrozenHistoryTypeEnum.UNFROZEN.getValue());
        accountFrozenHistory.setAccountNo(account.getAccountNo());
        accountFrozenHistory.setTrxType(tradeType.getValue());

        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setIsAllowSett(isAllowSett);
        accountHistory.setAmount(unFrozenAmount);
        accountHistory.setBalance(account.getAvailableBalance());
        accountHistory.setRequestNo(requestNo);
        accountHistory.setIsCompleteSett(PublicStatus.INACTIVE);
        accountHistory.setRemark(tradeType.getDesc() + "资金解冻");
        accountHistory.setFee(0D);
        accountHistory.setFundDirection(AccountFundDirectionEnum.ADD.getValue());
        accountHistory.setAccountNo(account.getAccountNo());
        accountHistory.setTrxType(tradeType.getValue());

        accountDao.update(account);
        accountHistoryDao.insert(accountHistory);
        accountFrozenHistoryDao.insert(accountFrozenHistory);

        log.info("===>unFrozen<===");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unfrozen_debit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeType, double fee) {
        this.unFrozen(userNo, amount, requestNo, tradeType);
        this.debit(userNo, amount, requestNo, tradeType, tradeType.getDesc(), fee);
    }
}
