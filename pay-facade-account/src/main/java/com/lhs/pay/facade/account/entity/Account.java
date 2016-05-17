package com.lhs.pay.facade.account.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * Account
 *
 * @author longhuashen
 * @since 16/5/17
 */
public class Account extends BaseEntity {

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 账户状态
     */
    private Integer status;

    /**
     * 账户余额
     */
    private Double balance = 0D;

    /**
     * 不可用余额
     */
    private Double unBalance = 0D;

    /**
     * 保证金
     */
    private Double securityBalance = 0D;

    /**
     * 账户类型
     */
    private Integer accountType;

    /**
     * 最后更新时间
     */
    private Date lastTime = new Date();

    /**
     * 可结算金额
     */
    private Double availableSettAccount = 0D;

    /**
     * 会计科目代码
     */
    private String accountTitleNo;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getUnBalance() {
        return unBalance;
    }

    public void setUnBalance(Double unBalance) {
        this.unBalance = unBalance;
    }

    public Double getSecurityBalance() {
        return securityBalance;
    }

    public void setSecurityBalance(Double securityBalance) {
        this.securityBalance = securityBalance;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Double getAvailableSettAccount() {
        return availableSettAccount;
    }

    public void setAvailableSettAccount(Double availableSettAccount) {
        this.availableSettAccount = availableSettAccount;
    }

    public String getAccountTitleNo() {
        return accountTitleNo;
    }

    public void setAccountTitleNo(String accountTitleNo) {
        this.accountTitleNo = accountTitleNo;
    }
}
