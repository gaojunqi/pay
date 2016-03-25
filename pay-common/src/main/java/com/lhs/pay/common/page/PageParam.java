package com.lhs.pay.common.page;

import java.io.Serializable;

/**
 * PageParam
 * 分页参数传递工具
 *
 * @author longhuashen
 * @since 16/3/21
 */
public class PageParam implements Serializable {

    /**
     * 当前页数
     */
    private int pageNum;

    /**
     * 每页记录数
     */
    private int numPerPage;

    public PageParam(int pageNum, int numPerPage) {
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }
}
