package com.lhs.pay.core.boss.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.boss.entity.ContractManagement;

import java.util.List;

/**
 * IContractManagementDao
 *
 * @author longhuashen
 * @since 16/9/18
 */
public interface IContractManagementDao extends BaseDao<ContractManagement> {

    List<ContractManagement> getByMerchantId(String merchantId);

    ContractManagement getByUserNo(String merchantNo);
}
