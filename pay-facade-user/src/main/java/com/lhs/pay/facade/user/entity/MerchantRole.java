package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MerchantRole
 *
 * 用户权限管理-角色
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class MerchantRole extends BaseEntity {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述
     */
    private String remark;

    /**
     * 用户编号
     */
    private String userNo;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
