package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * Province
 *
 * 省份信息表
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class Province extends BaseEntity {

    /**
     * 省编号
     */
    private String provinceNo;

    /**
     * 省名称
     */
    private String provinceName;

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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
