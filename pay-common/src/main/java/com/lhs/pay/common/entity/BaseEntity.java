package com.lhs.pay.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 *
 * 基础实体类，包含实体公用属性
 *
 * @author longhuashen
 * @since 16/3/21
 */
public class BaseEntity implements Serializable {

    private Long id;

    private Integer version = 0;

    /**
     * 创建时间
     */
    protected Date createTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
