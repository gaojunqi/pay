package com.lhs.pay.core.account.biz;

/**
 * IAccountSettBiz
 *
 * @author longhuashen
 * @since 16/5/24
 */
public interface IAccountSettBiz {

    /**
     * 结算创建_T+0
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     * @param trxNo
     */
    void settCreateT0(String userNo, Double settAmount, String requestNo, String trxNo);

    /**
     * 结算成功
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     */
    void settSuccess(String userNo, Double settAmount, String requestNo);

    /**
     * 结算失败
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     */
    void settFail(String userNo, Double settAmount, String requestNo);

    /**
     * 结算汇总成功
     *
     * @param userNo
     * @param statDate
     * @param riskyDay
     */
    void settCollectSuccess(String userNo, String statDate, Integer riskyDay);

    /**
     * 结算创建
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     * @param userId
     */
    void settCreate(String userNo, Double settAmount, String requestNo, Long userId);
}
