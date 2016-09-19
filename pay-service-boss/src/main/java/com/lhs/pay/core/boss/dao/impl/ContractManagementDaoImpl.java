package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.IContractManagementDao;
import com.lhs.pay.facade.boss.entity.ContractManagement;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ContractManagementDaoImpl
 *
 * @author longhuashen
 * @since 16/9/18
 */
@Repository("contractManagementDao")
public class ContractManagementDaoImpl extends BaseDaoImpl<ContractManagement> implements IContractManagementDao {

    @Override
    public List<ContractManagement> getByMerchantId(String merchantId) {
        return super.getSqlSession().selectList(getStatement("getByrelationId"), merchantId);
    }

    @Override
    public ContractManagement getByUserNo(String merchantNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", merchantNo);
        return super.getBy(map);
    }
}
