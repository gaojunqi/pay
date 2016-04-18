package com.lhs.pay.web.permission.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * PmsOperator
 *
 * @author longhuashen
 * @since 16/4/9
 */
public class PmsOperator extends BaseEntity {

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登陆密码
     */
    private String loginPwd;

    /**
     * 描述
     */
    private String remark;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 操作员类型 1：超级管理员 0：普通操作员 超级管理员由系统初始化生成，不能删除
     */
    private String type;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 是否更改过密码
     */
    private Boolean isChangedPwd;

    /**
     * 连续输错密码次数（5次就冻结账号）
     */
    private Integer pwdErrorCount;

    /**
     * 最后输错密码时间
     */
    private Date pwdErrorTime;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getIsChangedPwd() {
        return isChangedPwd;
    }

    public void setIsChangedPwd(Boolean isChangedPwd) {
        this.isChangedPwd = isChangedPwd;
    }

    public Integer getPwdErrorCount() {
        return pwdErrorCount;
    }

    public void setPwdErrorCount(Integer pwdErrorCount) {
        this.pwdErrorCount = pwdErrorCount;
    }

    public Date getPwdErrorTime() {
        return pwdErrorTime;
    }

    public void setPwdErrorTime(Date pwdErrorTime) {
        this.pwdErrorTime = pwdErrorTime;
    }
}
