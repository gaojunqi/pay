package com.lhs.pay.facade.user.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * MerchantAction
 *
 * 商户权限管理-权限功能点实体.
 *
 * @author longhuashen
 * @since 16/6/15
 */
public class MerchantAction extends BaseEntity {

    /**
     * 权限名称
     */
    private String actionName;

    /**
     * 权限
     */
    private String action;

    /**
     * 描述
     */
    private String remark;

    /**
     * 标示此权限是那个类型商户所有的
     */
    private Integer merchantBusType;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getMerchantBusType() {
        return merchantBusType;
    }

    public void setMerchantBusType(Integer merchantBusType) {
        this.merchantBusType = merchantBusType;
    }
}
