package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * EmailVerify
 *
 *  邮箱验证记录
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class EmailVerify extends BaseEntity {

    /**
     * 有效时间
     */
    private Date validTime;

    /**
     * 令牌(32为UUID)
     */
    private String token;

    /**
     * 类型 PublicTemplateEnum
     */
    private Integer type;

    /**
     * 状态 100：已验证 101：未验证
     */
    private Integer status;

    /**
     * 用户类型 对应用户类型枚举值
     */
    private Integer userType;

    /**
     * 接收邮箱
     */
    private String toEmail;

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
}
