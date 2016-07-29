package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * Score
 *
 * 积分信息实体
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class Score extends BaseEntity {

    /**
     * 账户ID
     */
    private String accountNo;

    /**
     * 登陆积分
     */
    private Long loginScore;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getLoginScore() {
        return loginScore;
    }

    public void setLoginScore(Long loginScore) {
        this.loginScore = loginScore;
    }
}
