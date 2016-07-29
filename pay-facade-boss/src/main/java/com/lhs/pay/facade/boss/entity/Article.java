package com.lhs.pay.facade.boss.entity;

import com.lhs.pay.common.entity.BaseEntity;

import java.util.Date;

/**
 * Article
 *
 * 1.企业动态 2.招聘 3.常见问题 4.产品管理 5.通知公告
 *
 * @author longhuashen
 * @since 16/7/29
 */
public class Article extends BaseEntity {

    /**
     * 类型
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 修改时间
     */
    private Date editTime;

    /**
     * 发布人id
     */
    private Long operatorId;

    /**
     * 发布人姓名
     */
    private String operatorName;

    /**
     * 类型1-门户系统 2-代理商系统
     */
    private Integer articleType;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }
}
