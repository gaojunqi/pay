package com.lhs.pay.core.account.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.account.dao.AccountHistoryDao;
import com.lhs.pay.facade.account.entity.AccountHistory;
import com.lhs.pay.facade.account.vo.DailyCollectAccountHistoryVo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountHistoryDaoImpl
 *
 * @author longhuashen
 * @since 16/5/20
 */
@Repository("accountHistoryDao")
public class AccountHistoryDaoImpl extends BaseDaoImpl<AccountHistory> implements AccountHistoryDao {

    @Override
    public AccountHistory getByAccountNo_requestNo_trxType(String accountNo, String requestNo, Integer trxType) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        params.put("requestNo", requestNo);
        params.put("trxType", trxType);
        return super.getBy(params);
    }

    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(String accountNo, String statDate, Integer riskDay, Integer fundDirection) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNO", accountNo);
        params.put("statDate", statDate);
        params.put("riskDay", riskDay);
        params.put("fundDirection", fundDirection);
        return super.getSessionTemplate().selectList(getStatement("listDailyCollectAccountHistoryVo"), params);
    }

    @Override
    public List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo_t0(String accountNo, String requestNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        params.put("requestNo", requestNo);
        return super.getSessionTemplate().selectList(getStatement("listDailyCollectAccountHistoryVo_t0"), params);
    }

    @Override
    public void updateCompleteSettTo100(String accountNo, String statDate, Integer riskyDay) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        params.put("statDate", statDate);
        params.put("riskyDay", riskyDay);
        super.getSessionTemplate().update(getStatement("updateCompleteSettTo100"), params);
    }

    @Override
    public void updateCompleteSettTo100_t0(String accountNo, String requestNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        params.put("requestNo", requestNo);
        super.getSessionTemplate().update(getStatement("updateCompleteSettTo100_t0"), params);
    }

    @Override
    public void updateCompleteSettTo100LastId(String accountNo, Long lastId) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        params.put("lastId", lastId);
        super.getSessionTemplate().update(getStatement("updateCompleteSettTo100LastId"), params);
    }
}
