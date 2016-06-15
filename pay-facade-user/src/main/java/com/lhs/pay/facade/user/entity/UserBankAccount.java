package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * UserBankAccount
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class UserBankAccount extends BaseEntity {

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行编码
     */
    private String bankCode;

    /**
     * 开户名称(持卡人)
     */
    private String bankAccountName;

    /**
     * 开户账号
     */
    private String bankAccountNo;

    /**
     * 协议号
     */
    private String contractNo;

    /**
     * 银行卡类型
     */
    private Integer bankAccountType;

    /**
     * 是否已验证(100:是,101:否,默认值为101)
     */
    private Integer isAuth;

    /**
     * 验证时间
     */
    private Date authTime;

    /**
     * 证件类型
     */
    private Integer cardType;

    /**
     * 证件号
     */
    private String cardNo;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 最后修改时间
     */
    private Date lastTime = new Date();

    /**
     * 是否已删除(100:是,101:否,默认值为101)
     */
    private Integer isDelete;

    /**
     * 是否默认(100:是,101:否,默认值为101)
     */
    private Integer isDefault;

    /**
     * 开户行所在省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 开户行地址
     */
    private String bankAccountAddress;

    /**
     * 银行行号
     */
    private String bankChannelNo;

    /**
     * 描述
     */
    private String remark;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(Integer bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBankAccountAddress() {
        return bankAccountAddress;
    }

    public void setBankAccountAddress(String bankAccountAddress) {
        this.bankAccountAddress = bankAccountAddress;
    }

    public String getBankChannelNo() {
        return bankChannelNo;
    }

    public void setBankChannelNo(String bankChannelNo) {
        this.bankChannelNo = bankChannelNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
