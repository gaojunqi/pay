package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * UserInfo
 *
 * 在线用户表
 *
 * @author longhuashen
 * @since 16/5/28
 */
public class UserInfo extends BaseEntity {

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 预留信息
     */
    private String greeting;

    /**
     * 安全保护问题
     */
    private String question;

    /**
     * 问题答案
     */
    private String answer;

    /**
     * 绑定手机号
     */
    private String bindMobileNo;

    /**
     * 绑定邮箱
     */
    private String bindEmail;

    /**
     * 所属地区
     */
    private String city;

    /**
     * 所属区域
     */
    private String area;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号码
     */
    private String cardNo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否邮箱验证
     */
    private Integer isEmailAuth;

    /**
     * 是否手机验证
     */
    private Integer isPhoneAuth;

    /**
     * 是否实名认证
     */
    private Integer isRealAuth;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBindEmail() {
        return bindEmail;
    }

    public void setBindEmail(String bindEmail) {
        this.bindEmail = bindEmail;
    }

    public String getBindMobileNo() {
        return bindMobileNo;
    }

    public void setBindMobileNo(String bindMobileNo) {
        this.bindMobileNo = bindMobileNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Integer getIsEmailAuth() {
        return isEmailAuth;
    }

    public void setIsEmailAuth(Integer isEmailAuth) {
        this.isEmailAuth = isEmailAuth;
    }

    public Integer getIsPhoneAuth() {
        return isPhoneAuth;
    }

    public void setIsPhoneAuth(Integer isPhoneAuth) {
        this.isPhoneAuth = isPhoneAuth;
    }

    public Integer getIsRealAuth() {
        return isRealAuth;
    }

    public void setIsRealAuth(Integer isRealAuth) {
        this.isRealAuth = isRealAuth;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
