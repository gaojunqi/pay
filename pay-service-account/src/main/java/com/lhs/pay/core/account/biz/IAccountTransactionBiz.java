package com.lhs.pay.core.account.biz;

import com.lhs.pay.facade.account.enums.AccountTradeTypeEnum;
import com.lhs.pay.facade.account.vo.AccountTransactionVo;

import java.util.List;

/**
 * IAccountTransactionBiz
 *
 * @author longhuashen
 * @since 16/5/24
 */
public interface IAccountTransactionBiz {

    /**
     * 账户收/付款
     *
     * @param accountTransactionVo
     */
    void execute(AccountTransactionVo accountTransactionVo);

    /**
     * 账户收/付款
     *
     * @param accountTransactionVos
     */
    void execute(List<AccountTransactionVo> accountTransactionVos);

    /**
     * 同一账户批量加款
     *
     * @param accountTransactionVos
     */
    void batchCreditForSameAccount(List<AccountTransactionVo> accountTransactionVos);

    /**
     * 加款
     *
     * @param userNo
     * @param amount
     * @param requestNo
     * @param tradeType
     * @param remark
     * @param riskyDay
     * @param fee
     * @return
     */
    String credit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeType, String remark, Integer riskyDay, double fee);

    /**
     * 减款
     *
     * @param userNo
     * @param amount
     * @param requestNo
     * @param tradeType
     * @param remark
     * @param fee
     * @return
     */
    String debit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeType, String remark, double fee);

    /**
     * 资金冻结
     *
     * @param userNo
     * @param frozenAmount
     * @param requestNo
     * @param tradeType
     */
    void frozen(String userNo, double frozenAmount, String requestNo, AccountTradeTypeEnum tradeType);

    /**
     * 资金解冻
     *
     * @param userNo
     * @param unFrozenAmount
     * @param requestNo
     * @param tradeType
     */
    void unFrozen(String userNo, double unFrozenAmount, String requestNo, AccountTradeTypeEnum tradeType);

    /**
     * 资金解冻并减款
     *
     * @param userNo
     * @param amount
     * @param requestNo
     * @param tradeType
     * @param fee
     */
    void unfrozen_debit(String userNo, double amount, String requestNo, AccountTradeTypeEnum tradeType, double fee);
}
