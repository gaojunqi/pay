package com.lhs.pay.core.account.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.account.entity.AccountHistory;
import com.lhs.pay.facade.account.vo.DailyCollectAccountHistoryVo;

import java.util.List;

/**
 * AccountHistoryDao
 *
 * @author longhuashen
 * @since 16/5/20
 */
public interface AccountHistoryDao extends BaseDao<AccountHistory> {

    /**
     * 获取账户历史
     *
     * @param accountNo
     * @param requestNo
     * @param trxType
     * @return
     */
    AccountHistory getByAccountNo_requestNo_trxType(String accountNo, String requestNo, Integer trxType);

    /**
     * 日汇总账户待结算金额
     *
     * @param accountNo
     * @param statDate
     * @param riskDay
     * @param fundDirection
     * @return
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskDay, Integer fundDirection);

    /**
     * 日汇总账户待结算金额t+0结算
     *
     * @param accountNo
     * @param requestNo
     * @return
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo);

    /**
     * 更新账户风险预存期外的账户历史记录为结算完成
     *
     * @param accountNo
     * @param statDate
     * @param riskyDay
     */
    void updateCompleteSettTo100(String accountNo, String statDate, Integer riskyDay);

    /**
     * 更新账户风险预存期外的账户历史记录为结算完成_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     */
    void updateCompleteSettTo100_t0(String accountNo, String requestNo);

    /**
     * 更新账户历史记录为结算完成
     *
     * @param accountNo
     * @param lastId
     */
    void updateCompleteSettTo100LastId(String accountNo, Long lastId);
}
