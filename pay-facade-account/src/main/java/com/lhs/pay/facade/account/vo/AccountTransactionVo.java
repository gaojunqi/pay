package com.lhs.pay.facade.account.vo;

import com.lhs.pay.facade.account.enums.AccountFundDirectionEnum;
import com.lhs.pay.facade.account.enums.AccountTradeTypeEnum;

import java.io.Serializable;

/**
 * AccountTransactionVo
 *
 * 交易命令参数vo
 *
 * @author longhuashen
 * @since 16/5/18
 */
public class AccountTransactionVo implements Serializable {

    /**
     * 资金方向
     */
    private AccountFundDirectionEnum accountFundDirection;

    /**
     * 交易码
     */
    private AccountTradeTypeEnum tradeType;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 手续费
     */
    private double fee = 0D;

    /**
     * 发生金额
     */
    private double amount = 0D;

    /**
     * 冻结金额
     */
    private double frezonAmount = 0D;

    /**
     * 解冻金额
     */
    private double unFrezonAmount = 0D;

    /**
     * 业务请求标识号
     */
    private String requestNo;

    /**
     * 描述
     */
    private String desc;

    /**
     * 风险预存期天数
     */
    private Integer riskDay;

    public AccountFundDirectionEnum getAccountFundDirection() {
        return accountFundDirection;
    }

    public void setAccountFundDirection(AccountFundDirectionEnum accountFundDirection) {
        this.accountFundDirection = accountFundDirection;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFrezonAmount() {
        return frezonAmount;
    }

    public void setFrezonAmount(double frezonAmount) {
        this.frezonAmount = frezonAmount;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Integer getRiskDay() {
        return riskDay;
    }

    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }

    public AccountTradeTypeEnum getTradeType() {
        return tradeType;
    }

    public void setTradeType(AccountTradeTypeEnum tradeType) {
        this.tradeType = tradeType;
    }

    public double getUnFrezonAmount() {
        return unFrezonAmount;
    }

    public void setUnFrezonAmount(double unFrezonAmount) {
        this.unFrezonAmount = unFrezonAmount;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
