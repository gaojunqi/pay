package com.lhs.pay.core.account.biz.impl;

import com.lhs.pay.core.account.biz.IAccountSettBiz;
import com.lhs.pay.core.account.dao.AccountDao;
import com.lhs.pay.core.account.dao.AccountHistoryDao;
import com.lhs.pay.facade.account.entity.Account;
import com.lhs.pay.facade.account.enums.AccountFundDirectionEnum;
import com.lhs.pay.facade.account.enums.AccountTradeTypeEnum;
import com.lhs.pay.facade.account.exception.AccountBizException;
import com.lhs.pay.facade.account.vo.AccountTransactionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountSettBizImpl
 *
 * @author longhuashen
 * @since 16/5/24
 */
@Service("accountSettBiz")
public class AccountSettBizImpl implements IAccountSettBiz {

    private static final Logger log = LoggerFactory.getLogger(AccountSettBizImpl.class);

    @Autowired
    private AccountHistoryDao accountHistoryDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public void settCreateT0(String userNo, Double settAmount, String requestNo, String trxNo) {
        log.info("settCreateT0, userNo:{}\n, requestNo:{}", userNo, requestNo);
        Account account = accountDao.getByUserNo_IsPessimist(userNo, false);

        if (account == null) {
            throw AccountBizException.ACCOUNT_NOT_EXIT.newInstance("账户不存在，用户编号{%s}", userNo).print();
        }

        List<AccountTransactionVo> voList = new ArrayList<>();
        //账户资金冻结
        AccountTransactionVo vo = new AccountTransactionVo();
        vo.setAccountFundDirection(AccountFundDirectionEnum.FROZEN);
        vo.setUserNo(userNo);
        vo.setFrezonAmount(settAmount);
        vo.setRequestNo(requestNo);
        vo.setTradeType(AccountTradeTypeEnum.SETTLEMENT);
        vo.setDesc("资金冻结");
        voList.add(vo);


    }

    @Override
    public void settSuccess(String userNo, Double settAmount, String requestNo) {

    }

    @Override
    public void settFail(String userNo, Double settAmount, String requestNo) {

    }

    @Override
    public void settCollectSuccess(String userNo, String statDate, Integer riskyDay) {

    }

    @Override
    public void settCreate(String userNo, Double settAmount, String requestNo, Long userId) {

    }
}
