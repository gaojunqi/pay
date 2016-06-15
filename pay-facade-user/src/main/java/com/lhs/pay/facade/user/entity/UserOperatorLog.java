package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * UserOperatorLog
 *
 * 用户操作日志
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class UserOperatorLog extends BaseEntity {

    /**
     * 用户编号
     **/
    private String userNo;

    /**
     * 操作员登录名
     **/
    private String loginName;

    /**
     * 操作状态(1:成功,0:失败)
     **/
    private Integer operateStatus;

    /**
     * IP地址
     **/
    private String ip;

    /**
     * 操作内容
     **/
    private String content;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Integer operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
