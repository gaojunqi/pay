package com.lhs.pay.facade.account.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * AccountFrozenHistory
 *
 * @author longhuashen
 * @since 16/5/17
 */
public class AccountFrozenHistory extends BaseEntity {

    /**
     * 请求号
     */
    private String requestNo;

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 冻结/解冻金额
     */
    private Double ammount;

    /**
     * 当前冻结金额
     */
    private Double currentAmount;

    /**
     * 描述
     */
    private String remark;

    /**
     * 冻结/解冻(AccountFrozenHistoryTypeEnum)
     */
    private Integer accountFrozenHistoryType;

    /**
     * 交易类型(枚举AccountTradeTypeEnum)
     */
    private Integer trxType;

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

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAccountFrozenHistoryType() {
        return accountFrozenHistoryType;
    }

    public void setAccountFrozenHistoryType(Integer accountFrozenHistoryType) {
        this.accountFrozenHistoryType = accountFrozenHistoryType;
    }

    public Integer getTrxType() {
        return trxType;
    }

    public void setTrxType(Integer trxType) {
        this.trxType = trxType;
    }
}
