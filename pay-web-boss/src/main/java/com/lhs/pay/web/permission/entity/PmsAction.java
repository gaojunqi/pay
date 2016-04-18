package com.lhs.pay.web.permission.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * PmsAction
 *
 * 权限-权限表实体
 *
 * @author longhuashen
 * @since 16/4/17
 */
public class PmsAction extends BaseEntity {

    /**
     * 权限名称
     */
    private String actionName;

    /**
     * 权限标识
     */
    private String action;

    /**
     * 权限描述
     */
    private String remark;

    /**
     * 菜单ID
     */
    private PmsMenu pmsMenu;

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

    public PmsMenu getPmsMenu() {
        return pmsMenu;
    }

    public void setPmsMenu(PmsMenu pmsMenu) {
        this.pmsMenu = pmsMenu;
    }
}
