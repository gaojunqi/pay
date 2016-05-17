package com.lhs.pay.facade.account.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * AccountHistory
 *
 * @author longhuashen
 * @since 16/5/17
 */
public class AccountHistory extends BaseEntity {

    /**
     * 请求号
     */
    private String requestNo;

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 变动金额
     */
    private Double amount = 0D;

    /**
     * 手续费
     */
    private Double fee = 0D;

    /**
     * 余额
     */
    private Double balance = 0D;

    /**
     * 描述
     */
    private String remark;

    /**
     * 资金变动方向
     */
    private Integer fundDirection;

    /**
     * 是否允许结算
     */
    private Integer isAllowSett;

    /**
     * 是否完成结算
     */
    private Integer isCompleteSett;

    /**
     * 交易类型(枚举AccountTradeTypeEnum)
     */
    private Integer trxType;

    /**
     * 风险预存期天数
     */
    private Integer riskDay;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFundDirection() {
        return fundDirection;
    }

    public void setFundDirection(Integer fundDirection) {
        this.fundDirection = fundDirection;
    }

    public Integer getIsAllowSett() {
        return isAllowSett;
    }

    public void setIsAllowSett(Integer isAllowSett) {
        this.isAllowSett = isAllowSett;
    }

    public Integer getIsCompleteSett() {
        return isCompleteSett;
    }

    public void setIsCompleteSett(Integer isCompleteSett) {
        this.isCompleteSett = isCompleteSett;
    }

    public Integer getTrxType() {
        return trxType;
    }

    public void setTrxType(Integer trxType) {
        this.trxType = trxType;
    }

    public Integer getRiskDay() {
        return riskDay;
    }

    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }
}
