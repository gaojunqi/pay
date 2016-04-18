package com.lhs.pay.web.permission.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * PmsRoleOperator
 *
 * @author longhuashen
 * @since 16/4/9
 */
public class PmsRoleOperator extends BaseEntity {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 操作员id
     */
    private Long operatorId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
