package com.lhs.pay.core.account.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.account.dao.AccountDao;
import com.lhs.pay.facade.account.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * AccountDaoImpl
 *
 * @author longhuashen
 * @since 16/5/20
 */
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

    @Override
    public String buildAccountNo(String accountType) {
        //获取账户编号序列值，用于生成20位的账户编号
        String accountNoSeq = super.getSeqNextValue("ACCOUNT_NO_SEQ");
        return "8088" + accountType + accountNoSeq + "0101";
    }

    @Override
    public Account getByAccountNo(String accountNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("accountNo", accountNo);
        return super.getBy(params);
    }

    @Override
    public Account getByUserNo_IsPessimist(String userNo, boolean isPessimist) {
        Map<String, Object> params = new HashMap<>();
        params.put("userNo", userNo);
        params.put("isPessimit", isPessimist);
        return super.getBy(params);
    }
}
