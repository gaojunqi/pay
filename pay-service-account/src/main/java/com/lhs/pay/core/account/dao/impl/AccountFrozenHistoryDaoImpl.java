package com.lhs.pay.core.account.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.account.dao.AccountFrozenHistoryDao;
import com.lhs.pay.facade.account.entity.AccountFrozenHistory;
import org.springframework.stereotype.Repository;

/**
 * AccountFrozenHistoryDaoImpl
 *
 * @author longhuashen
 * @since 16/5/20
 */
@Repository("accountFrozenHistoryDao")
public class AccountFrozenHistoryDaoImpl extends BaseDaoImpl<AccountFrozenHistory> implements AccountFrozenHistoryDao {
}
