package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.ITownDao;
import com.lhs.pay.facade.boss.entity.Town;
import org.springframework.stereotype.Repository;

/**
 * TownDaoImpl
 *
 * @author longhuashen
 * @since 16/9/19
 */
@Repository("townDao")
public class TownDaoImpl extends BaseDaoImpl<Town> implements ITownDao {
}
