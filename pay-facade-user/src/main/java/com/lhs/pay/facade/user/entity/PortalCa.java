package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * PortalCa
 *
 * 门户CA证书信息表
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class PortalCa extends BaseEntity {

    /**
     * 会员、操作员id
     */
    private Long userId;

    /**
     * 商户类型
     */
    private Integer userType;

    /**
     * 使用地点id
     */
    private Integer addrId;

    /**
     * dn信息
     */
    private String dn;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     *
     */
    private String signCert;

    /**
     * 用户编号
     */
    private String userNo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSignCert() {
        return signCert;
    }

    public void setSignCert(String signCert) {
        this.signCert = signCert;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
