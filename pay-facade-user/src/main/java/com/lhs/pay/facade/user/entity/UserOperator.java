package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * UserOperator
 *
 * 权限管理-用户操作员
 *
 * @author longhuashen
 * @since 16/5/29
 */
public class UserOperator extends BaseEntity {

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登陆密码
     */
    private String loginPwd;

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
     * 操作员类型
     */
    private Integer type;

    /**
     * 是否更改过密码
     */
    private Integer isChangePwd;

    /**
     * 登陆密码错误次数
     */
    private Integer pwdErrorTimes;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 最后一次修改时间
     */
    private Date lastAlertPwdTime;

    public Integer getIsChangePwd() {
        return isChangePwd;
    }

    public void setIsChangePwd(Integer isChangePwd) {
        this.isChangePwd = isChangePwd;
    }

    public Date getLastAlertPwdTime() {
        return lastAlertPwdTime;
    }

    public void setLastAlertPwdTime(Date lastAlertPwdTime) {
        this.lastAlertPwdTime = lastAlertPwdTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getPwdErrorTimes() {
        return pwdErrorTimes;
    }

    public void setPwdErrorTimes(Integer pwdErrorTimes) {
        this.pwdErrorTimes = pwdErrorTimes;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
