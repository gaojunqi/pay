package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

/**
 * GlobalSet
 *
 * 数据库字段管理
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class GlobalSet extends BaseEntity {

    /**
     * ID名称
     */
    private String setKey;

    /**
     * 内容
     */
    private String setContent;

    /**
     * 描述
     */
    private String description;

    public String getSetKey() {
        return setKey;
    }

    public void setSetKey(String setKey) {
        this.setKey = setKey;
    }

    public String getSetContent() {
        return setContent;
    }

    public void setSetContent(String setContent) {
        this.setContent = setContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
