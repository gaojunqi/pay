package com.lhs.pay.facade.boss.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.boss.entity.Sales;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.List;
import java.util.Map;

/**
 * SalesFacade
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface SalesFacade {

    long create(Sales sales) throws BossBizException;

    long update(Sales sales) throws BossBizException;

    Sales getById(long salesId) throws BossBizException;

    PageBean querySalesPage(PageParam pageParam, Map<String, Object> paramMap) throws BossBizException;

    List listByCondition(Map<String, Object> paramMap) throws BossBizException;

    String buildsalesNo() throws BossBizException;
}
