package com.lhs.pay.facade.account.service.impl;

import com.lhs.pay.common.exceptions.BizException;
import com.lhs.pay.core.account.biz.IAccountTransactionBiz;
import com.lhs.pay.facade.account.enums.AccountTradeTypeEnum;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.service.AccountTransactionFacade;
import com.lhs.pay.facade.account.vo.AccountTransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccountTransactionFacadeImpl
 *
 * @author longhuashen
 * @since 16/5/24
 */
@Service("accountTransactionFacade")
public class AccountTransactionFacadeImpl implements AccountTransactionFacade {

    @Autowired
    private IAccountTransactionBiz accountTransactionBiz;

    @Override
    public void execute(AccountTransactionVo vo) throws AccountBizException {
        accountTransactionBiz.execute(vo);
    }

    @Override
    public void execute(List<AccountTransactionVo> voList) throws AccountBizException, BizException {
        accountTransactionBiz.execute(voList);
    }

    @Override
    public void batchCreditForSameAccount(List<AccountTransactionVo> voList) throws AccountBizException {
        accountTransactionBiz.batchCreditForSameAccount(voList);
    }

    @Override
    public void frozen(String userNo, double frozenAmount, String requestNo, AccountTradeTypeEnum tradeTypeEnum) throws AccountBizException {
        accountTransactionBiz.frozen(userNo, frozenAmount, requestNo, tradeTypeEnum);
    }

    @Override
    public void unFrozen(String userNo, double unFrozenAmount, String requestNo, AccountTradeTypeEnum tradeTypeEnum) throws AccountBizException {
        accountTransactionBiz.unFrozen(userNo, unFrozenAmount, requestNo, tradeTypeEnum);
    }

    @Override
    public void unFrozen_debit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeTypeEnum, double fee) throws AccountBizException {
        accountTransactionBiz.unfrozen_debit(userNo, amount, requestNo, tradeTypeEnum, fee);
    }
}
