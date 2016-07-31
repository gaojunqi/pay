package com.lhs.pay.facade.boss.service;

import com.lhs.pay.facade.boss.entity.MerchantSales;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.List;
import java.util.Map;

/**
 * MerchantSalesFacade
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface MerchantSalesFacade {

    long create(MerchantSales sales) throws BossBizException;

    long update(MerchantSales sales) throws BossBizException;

    MerchantSales getById(long id) throws BossBizException;

    MerchantSales getByMerchantNo(String merchantNo);

    void deleteById(long id);

    List<MerchantSales> listByCondition(Map<String, Object> paramMap) throws BossBizException;
}
