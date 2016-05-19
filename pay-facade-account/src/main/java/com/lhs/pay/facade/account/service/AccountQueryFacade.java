package com.lhs.pay.facade.account.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.account.entity.Account;
import com.lhs.pay.facade.account.entity.AccountHistory;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.vo.DailyCollectAccountHistoryVo;

import java.util.List;
import java.util.Map;

/**
 * AccountQueryFacade
 *
 * 账户查询接口
 *
 * @author longhuashen
 * @since 16/5/18
 */
public interface AccountQueryFacade {

    /**
     * 账户历史查询
     *
     * @param pageParam
     * @param paramMap
     * @return
     * @throws AccountBizException
     */
    PageBean queryAccountHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException;

    /**
     * 获取账户历史
     *
     * @param accountNo
     * @param requestNo
     * @param trxType
     * @return
     * @throws AccountBizException
     */
    AccountHistory getAccountHistoryByAccountNo_trxType(String accountNo, String requestNo, Integer trxType) throws AccountBizException;

    /**
     * 根据账户编号查询账户信息
     *
     * @param accountNo
     * @return
     * @throws AccountBizException
     */
    Account getAccountByUserNo(String accountNo) throws AccountBizException;

    /**
     * 日汇总账户待结算金额
     *
     * @param accountNo
     * @param statDate
     * @param riskyDay
     * @param fundDirection
     * @return
     * @throws AccountBizException
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskyDay, Integer fundDirection) throws AccountBizException;

    /**
     * 日汇总账户待结算金额_针对单笔t+0结算
     *
     * @param accountNo
     * @param requestNo
     * @return
     * @throws AccountBizException
     */
    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo) throws AccountBizException;
}
