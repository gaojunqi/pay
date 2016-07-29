package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * Sales
 *
 * 销售人员表
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class Sales extends BaseEntity {

    /**
     * 销售人员编号
     */
    private String salesNo;

    /**
     * 销售人员名称
     */
    private String salesName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 状态 100：激活 101：冻结
     */
    private Integer status;

    /**
     * 描述
     */
    private String description;

    public String getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(String salesNo) {
        this.salesNo = salesNo;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
