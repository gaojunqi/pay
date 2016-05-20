package com.lhs.pay.core.account.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.account.entity.Account;

/**
 * AccountDao
 *
 * @author longhuashen
 * @since 16/5/20
 */
public interface AccountDao extends BaseDao<Account> {

    /**
     * 生成账户编号20位
     *
     * @param accountType
     * @return
     */
    String buildAccountNo(String accountType);

    /**
     * 根据账户编号获取账户信息
     *
     * @param accountNo
     * @return
     */
    Account getByAccountNo(String accountNo);

    /**
     * 获取账户实体
     *
     * @param userNo
     * @param isPessimist 是否乐观锁
     * @return
     */
    Account getByUserNo_IsPessimist(String userNo, boolean isPessimist);
}
