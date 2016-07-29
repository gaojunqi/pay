package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MerchantSales
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class MerchantSales extends BaseEntity {

    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 销售人员ID
     */
    private Long salesId;

    /**
     * 商户名称
     */
    private String merchantFullName;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Long getSalesId() {
        return salesId;
    }

    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    public String getMerchantFullName() {
        return merchantFullName;
    }

    public void setMerchantFullName(String merchantFullName) {
        this.merchantFullName = merchantFullName;
    }
}
