package com.lhs.pay.facade.account.service;

import com.lhs.pay.common.exceptions.BizException;
import com.lhs.pay.facade.account.enums.AccountTradeTypeEnum;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.vo.AccountTransactionVo;

import java.util.List;

/**
 * AccountTransactionFacade
 *
 * 账户交易接口
 *
 * @author longhuashen
 * @since 16/5/19
 */
public interface AccountTransactionFacade {

    /**
     * 账户收/付款(单笔)
     *
     * @param vo
     * @throws AccountBizException
     */
    void execute(AccountTransactionVo vo) throws AccountBizException;

    /**
     * 账户收/付款(批量)
     *
     * @param voList
     * @throws AccountBizException
     * @throws BizException
     */
    void execute(List<AccountTransactionVo> voList) throws AccountBizException, BizException;

    /**
     *  同一账户批量加款
     *
     * @param voList
     * @throws AccountBizException
     */
    void batchCreditForSameAccount(List<AccountTransactionVo> voList) throws AccountBizException;

    /**
     * 资金冻结
     *
     * @param userNo
     * @param frozenAmount
     * @param requestNo
     * @param tradeTypeEnum
     * @throws AccountBizException
     */
    void frozen(String userNo, double frozenAmount, String requestNo, AccountTradeTypeEnum tradeTypeEnum) throws AccountBizException;

    /**
     * 资金解冻
     *
     * @param userNo
     * @param unFrozenAmount
     * @param requestNo
     * @param tradeTypeEnum
     * @throws AccountBizException
     */
    void unFrozen(String userNo, double unFrozenAmount, String requestNo, AccountTradeTypeEnum tradeTypeEnum) throws AccountBizException;

    /**
     * 资金解冻并减款
     *
     * @param userNo
     * @param amount
     * @param requestNo
     * @param tradeTypeEnum
     * @throws AccountBizException
     */
    void unFrozen_debit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeTypeEnum) throws AccountBizException;
}
