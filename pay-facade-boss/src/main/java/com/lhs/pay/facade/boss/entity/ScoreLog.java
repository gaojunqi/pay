package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * ScoreLog
 *
 * 积分日志信息
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class ScoreLog extends BaseEntity {

    /**
     * 账户ID
     */
    private String accountNo;

    /**
     * 变动积分
     */
    private Long changeScore;

    /**
     * 积分变动说明
     */
    private String changeDesc;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getChangeScore() {
        return changeScore;
    }

    public void setChangeScore(Long changeScore) {
        this.changeScore = changeScore;
    }

    public String getChangeDesc() {
        return changeDesc;
    }

    public void setChangeDesc(String changeDesc) {
        this.changeDesc = changeDesc;
    }
}
