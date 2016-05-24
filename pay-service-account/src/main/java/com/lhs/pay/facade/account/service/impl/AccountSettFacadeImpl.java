package com.lhs.pay.facade.account.service.impl;

import com.lhs.pay.core.account.biz.IAccountSettBiz;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.service.AccountSettFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountSettFacadeImpl
 *
 * @author longhuashen
 * @since 16/5/24
 */
@Service("accountSettFacade")
public class AccountSettFacadeImpl implements AccountSettFacade {

    @Autowired
    private IAccountSettBiz accountSettBiz;

    @Override
    public void settCreateT0(String userNo, Double settAccount, String requestNo, String trxNo) throws AccountBizException {
        accountSettBiz.settCreateT0(userNo, settAccount, requestNo, trxNo);
    }

    @Override
    public void settSuccess(String userNo, Double settAccount, String requestNo) throws AccountBizException {
        accountSettBiz.settSuccess(userNo, settAccount, requestNo);
    }

    @Override
    public void settCollectSuccess(String userNo, String statDate, Integer riskyDay) throws AccountBizException {
        accountSettBiz.settCollectSuccess(userNo, statDate, riskyDay);
    }

    @Override
    public void settCreate(String userNo, Double settAccount, String requestNo, Long lastId) throws AccountBizException {
        accountSettBiz.settCreate(userNo, settAccount, requestNo, lastId);
    }

    @Override
    public void settFail(String userNo, Double settAmount, String requestNo) throws AccountBizException {
        accountSettBiz.settFail(userNo, settAmount, requestNo);
    }
}
