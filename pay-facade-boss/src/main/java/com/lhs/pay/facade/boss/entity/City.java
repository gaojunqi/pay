package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * City
 *
 * 市信息表
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class City extends BaseEntity {

    /**
     * 省编号
     */
    private String provinceNo;

    /**
     * 市编号
     */
    private String cityNo;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 排序号
     */
    private Integer orders;

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
