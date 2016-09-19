package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.IGlobalSetDao;
import com.lhs.pay.facade.boss.entity.GlobalSet;
import org.springframework.stereotype.Repository;

/**
 * GlobalSetDaoImpl
 *
 * @author longhuashen
 * @since 16/9/19
 */
@Repository("globalSetDao")
public class GlobalSetDaoImpl extends BaseDaoImpl<GlobalSet> implements IGlobalSetDao {
}
