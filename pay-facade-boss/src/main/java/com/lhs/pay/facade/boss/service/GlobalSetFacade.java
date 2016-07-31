package com.lhs.pay.facade.boss.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.boss.entity.GlobalSet;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.Map;

/**
 * GlobalSetFacade
 *
 * 运营全局设置
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface GlobalSetFacade {

    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws BossBizException;

    GlobalSet getById(long id) throws BossBizException;

    long update(GlobalSet entity) throws BossBizException;

    /**
     * 根据键名查询全局设置表数据
     *
     * @param keyValue
     * @return
     * @throws BossBizException
     */
    GlobalSet getBySetKey(String keyValue) throws BossBizException;
}
