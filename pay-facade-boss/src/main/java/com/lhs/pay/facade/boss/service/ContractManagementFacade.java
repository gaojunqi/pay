package com.lhs.pay.facade.boss.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.boss.entity.ContractManagement;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.List;
import java.util.Map;

/**
 * ContractManagementFacade
 *
 * 合同管理接口
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface ContractManagementFacade {

    long create(ContractManagement entity) throws BossBizException;

    long update(ContractManagement entity) throws BossBizException;

    ContractManagement getById(long id) throws BossBizException;

    ContractManagement getBy(Map<String, Object> map) throws BossBizException;

    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws BossBizException;

    List<ContractManagement> getByMerchantId(String merchantId) throws BossBizException;

    ContractManagement getByUserNo(String merchantNo) throws BossBizException;
}
