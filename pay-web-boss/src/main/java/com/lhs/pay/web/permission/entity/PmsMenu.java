package com.lhs.pay.web.permission.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * PmsMenu
 *
 * @author longhuashen
 * @since 16/4/12
 */
public class PmsMenu extends BaseEntity {

    /**
     * 菜单名称NAME
     */
    private String name;

    /**
     * 菜单地址URL
     */
    private String url;

    /**
     * 父菜单PARNETID
     */
    private PmsMenu parent;

    /**
     * 菜单编号NUMBER
     */
    private String number;

    /**
     * 是否下级节点ISLEAF
     */
    private boolean isLeaf;

    /**
     * 级别
     */
    private Long level;

    /**
     * 用于刷新页面的配置
     */
    private String targetName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PmsMenu getParent() {
        return parent;
    }

    public void setParent(PmsMenu parent) {
        this.parent = parent;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
