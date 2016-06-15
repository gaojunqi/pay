package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MerchantRoleOperator
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class MerchantRoleOperator extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 操作员ID
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
