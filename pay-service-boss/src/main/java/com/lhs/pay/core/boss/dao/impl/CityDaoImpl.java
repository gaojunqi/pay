package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.ICityDao;
import com.lhs.pay.facade.boss.entity.City;
import org.springframework.stereotype.Repository;

/**
 * CityDaoImpl
 *
 * @author longhuashen
 * @since 16/9/18
 */
@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City> implements ICityDao {
}
