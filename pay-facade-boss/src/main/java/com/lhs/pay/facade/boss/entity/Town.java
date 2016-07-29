package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * Town
 *
 * 地区管理-镇区信息
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class Town extends BaseEntity {

    /**
     * 地市编号
     */
    private String cityNo;

    /**
     * 镇区编号
     */
    private String townNo;

    /**
     * 镇区名称
     */
    private String townName;

    /**
     * 排序号
     */
    private Integer orders;

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getTownNo() {
        return townNo;
    }

    public void setTownNo(String townNo) {
        this.townNo = townNo;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
