package com.lhs.pay.web.permission.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * PmsRole
 *
 * @author longhuashen
 * @since 16/4/11
 */
public class PmsRole extends BaseEntity {

    /**
     * 角色类型
     */
    private String roleType;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述
     */
    private String remark;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

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
}
