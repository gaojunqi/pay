package com.lhs.pay.facade.boss.service;

import com.lhs.pay.facade.boss.entity.City;
import com.lhs.pay.facade.boss.entity.Province;
import com.lhs.pay.facade.boss.entity.Town;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.List;
import java.util.Map;

/**
 * ProvinceFacade
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface ProvinceFacade {

    /**
     * 查询省列表
     *
     * @param paramMap
     * @return
     * @throws BossBizException
     */
    List listProvince(Map<String, Object> paramMap) throws BossBizException;

    /**
     * 根据省编号查询
     *
     * @param code
     * @return
     * @throws BossBizException
     */
    Province getProvinceByCode(String code) throws BossBizException;

    /**
     * 查询城市列表
     *
     * @param paramMap
     * @return
     * @throws BossBizException
     */
    List listCityBy(Map<String, Object> paramMap) throws BossBizException;

    /**
     * 根据市编号查询
     *
     * @param code
     * @return
     * @throws BossBizException
     */
    City getCityByCode(String code) throws BossBizException;

    /**
     * 查询地区城镇列表
     *
     * @param paramMap
     * @return
     * @throws BossBizException
     */
    List listTownBy(Map<String, Object> paramMap) throws  BossBizException;

    /**
     * 根据地区编号查询
     *
     * @param code
     * @return
     * @throws BossBizException
     */
    Town getTownByCode(String code) throws BossBizException;
}
