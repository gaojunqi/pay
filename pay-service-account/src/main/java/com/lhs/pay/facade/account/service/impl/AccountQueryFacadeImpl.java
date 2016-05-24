package com.lhs.pay.facade.account.service.impl;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.core.account.dao.AccountDao;
import com.lhs.pay.core.account.dao.AccountHistoryDao;
import com.lhs.pay.facade.account.entity.Account;
import com.lhs.pay.facade.account.entity.AccountHistory;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.service.AccountQueryFacade;
import com.lhs.pay.facade.account.vo.DailyCollectAccountHistoryVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * AccountQueryFacadeImpl
 *
 * @author longhuashen
 * @since 16/5/24
 */
@Service("accountQueryFacade")
public class AccountQueryFacadeImpl implements AccountQueryFacade {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountHistoryDao accountHistoryDao;

    @Override
    public PageBean queryAccountHistoryListPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountBizException {
        return accountHistoryDao.listPage(pageParam, paramMap);
    }

    @Override
    public AccountHistory getAccountHistoryByAccountNo_trxType(String accountNo, String requestNo, Integer trxType) throws AccountBizException {
        return accountHistoryDao.getByAccountNo_requestNo_trxType(accountNo, requestNo, trxType);
    }

    @Override
    public Account getAccountByUserNo(String userNo) throws AccountBizException {
        if (Strings.isBlank(userNo)) {
            return null;
        }
        return accountDao.getByUserNo_IsPessimist(userNo, false);
    }

    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskyDay, Integer fundDirection) throws AccountBizException {
        return accountHistoryDao.listDailyCollectAccountHistoryVo(accountNo, statDate, riskyDay, fundDirection);
    }

    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo) throws AccountBizException {
        return accountHistoryDao.listDailyCollectAccountHistoryVo_t0(accountNo, requestNo);
    }
}
