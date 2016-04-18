package com.lhs.pay.web.permission.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * PmsRoleAction
 *
 * 权限-角色权限关联表
 *
 * @author longhuashen
 * @since 16/4/18
 */
public class PmsRoleAction extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long actionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }
}
