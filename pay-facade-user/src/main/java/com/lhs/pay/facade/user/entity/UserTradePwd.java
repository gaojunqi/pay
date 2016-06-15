package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * UserTradePwd
 *
 * 用户交易密码对象
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class UserTradePwd extends BaseEntity {

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 交易密码
     */
    private String tradePwd;

    /**
     * 输入错误次数
     */
    private Integer pwdErrorTimes;

    /**
     * 最后一次输入时间
     */
    private Date pwdErrorLastTime = new Date();

    /**
     * 是否是初始密码 如果==1，则是，需提示修改
     */
    private Integer isInitialPwd;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

    public Integer getPwdErrorTimes() {
        return pwdErrorTimes;
    }

    public void setPwdErrorTimes(Integer pwdErrorTimes) {
        this.pwdErrorTimes = pwdErrorTimes;
    }

    public Date getPwdErrorLastTime() {
        return pwdErrorLastTime;
    }

    public void setPwdErrorLastTime(Date pwdErrorLastTime) {
        this.pwdErrorLastTime = pwdErrorLastTime;
    }

    public Integer getIsInitialPwd() {
        return isInitialPwd;
    }

    public void setIsInitialPwd(Integer isInitialPwd) {
        this.isInitialPwd = isInitialPwd;
    }
}
