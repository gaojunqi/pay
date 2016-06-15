package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * UserRelation
 *
 * 用户父子关系表
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class UserRelation extends BaseEntity {

    /**
     * 父用户编号
     */
    private String parentUserNo;

    /**
     * 子用户编号
     */
    private String childUserNo;

    public String getParentUserNo() {
        return parentUserNo;
    }

    public void setParentUserNo(String parentUserNo) {
        this.parentUserNo = parentUserNo;
    }

    public String getChildUserNo() {
        return childUserNo;
    }

    public void setChildUserNo(String childUserNo) {
        this.childUserNo = childUserNo;
    }
}
