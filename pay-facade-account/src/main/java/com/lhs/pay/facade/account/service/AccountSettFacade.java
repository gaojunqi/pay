package com.lhs.pay.facade.account.service;

import com.lhs.pay.facade.account.exception.AccountBizException;

/**
 * AccountSettFacade
 *
 * 账户结算接口
 *
 * @author longhuashen
 * @since 16/5/19
 */
public interface AccountSettFacade {

    /**
     * 结算创建_T+0
     *
     * @param userNo
     * @param settAccount
     * @param requestNo
     * @param trxNo
     * @throws AccountBizException
     */
    void settCreateT0(String userNo, Double settAccount, String requestNo, String trxNo) throws AccountBizException;

    /**
     * 结算成功
     *
     * @param userNo
     * @param settAccount
     * @param requestNo
     * @throws AccountBizException
     */
    void settSuccess(String userNo, Double settAccount, String requestNo) throws AccountBizException;

    /**
     * 结算汇总成功
     *
     * @param settNo
     * @param startDate
     * @param riskyDay
     * @throws AccountBizException
     */
    void settCollectSuccess(String settNo, String startDate, Integer riskyDay) throws AccountBizException;

    /**
     * 结算创建
     *
     * @param userNo
     * @param settAccount
     * @param requestNo
     * @param lastId
     * @throws AccountBizException
     */
    void settCreate(String userNo, Double settAccount, String requestNo, Long lastId) throws AccountBizException;

    /**
     * 结算失败
     *
     * @param userNo
     * @param settAmount
     * @param requestNo
     * @throws AccountBizException
     */
    void settFail(String userNo, Double settAmount, String requestNo) throws AccountBizException;
}
