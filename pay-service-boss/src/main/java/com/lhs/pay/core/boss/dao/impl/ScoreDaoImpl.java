package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.IScoreDao;
import com.lhs.pay.facade.boss.entity.Score;
import org.springframework.stereotype.Repository;

/**
 * ScoreDaoImpl
 *
 * @author longhuashen
 * @since 16/9/19
 */
@Repository("scoreDao")
public class ScoreDaoImpl extends BaseDaoImpl<Score> implements IScoreDao {
}
