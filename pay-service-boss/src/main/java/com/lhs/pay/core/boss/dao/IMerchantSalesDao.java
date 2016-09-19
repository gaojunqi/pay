package com.lhs.pay.core.boss.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.boss.entity.MerchantSales;

import java.util.List;
import java.util.Map;

/**
 * IMerchantSalesDao
 *
 * @author longhuashen
 * @since 16/9/19
 */
public interface IMerchantSalesDao extends BaseDao<MerchantSales> {

    MerchantSales getByMerchantNo(String merchantNo);

    List<MerchantSales> listByCondition(Map<String, Object> paramMap);
}
