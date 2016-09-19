package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.IProvinceDao;
import com.lhs.pay.facade.boss.entity.Province;
import org.springframework.stereotype.Repository;

/**
 * ProvinceDaoImpl
 *
 * @author longhuashen
 * @since 16/9/19
 */
@Repository("provinceDao")
public class ProvinceDaoImpl extends BaseDaoImpl<Province> implements IProvinceDao {
}
