package com.lhs.pay.facade.account.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * AccountFrozenRecord
 *
 * @author longhuashen
 * @since 16/5/17
 */
public class AccountFrozenRecord extends BaseEntity {

    /**
     * 账户编号
     */
    private String accountNo;

    /**
     * 发起人(AccountInitiatorEnum)
     */
    private Integer initiator;

    /**
     * 账户操作类型(AccountOperationTypeEnum)
     */
    private Integer operationType;

    /**
     * 最后更新时间
     */
    private Date lastTime = new Date();

    /**
     * 操作描述
     */
    private String remark;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getInitiator() {
        return initiator;
    }

    public void setInitiator(Integer initiator) {
        this.initiator = initiator;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
