package com.lhs.pay.core.account.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.account.dao.AccountFrozenRecordDao;
import com.lhs.pay.facade.account.entity.AccountFrozenRecord;
import org.springframework.stereotype.Repository;

/**
 * AccountFrozenRecordDaoImpl
 *
 * @author longhuashen
 * @since 16/5/20
 */
@Repository("accountFrozenRecordDao")
public class AccountFrozenRecordDaoImpl extends BaseDaoImpl<AccountFrozenRecord> implements AccountFrozenRecordDao {
}
