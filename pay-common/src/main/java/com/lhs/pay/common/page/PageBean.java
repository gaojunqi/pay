package com.lhs.pay.common.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * PageBean
 * 分页组件
 *
 * @author longhuashen
 * @since 16/3/21
 */
public class PageBean implements Serializable {

    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 每页显示多少条
     */
    private int numPerPage;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 本页的数据列表
     */
    private List<Object> recordList;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 页码列表的开始索引
     */
    private int beginPageIndex;

    /**
     * 页码列表的结束索引
     */
    private int endPageIndex;

    /**
     * 当前分页条件下的统计结果
     */
    private Map<String, Object> countResultMap;

    public PageBean() {
    }

    /**
     * 根据传入的参数计算出结果
     * @param currentPage
     * @param numPerPage
     * @param totalCount
     * @param recordList
     */
    public PageBean(int currentPage, int numPerPage, int totalCount, List<Object> recordList) {
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
        this.totalCount = totalCount;
        this.recordList = recordList;

        //计算总页码
        this.pageCount = (totalCount + numPerPage - 1) / numPerPage;

        //计算beginPageIndex和endPageIndex
        if (this.pageCount <= 10) {//总页数不多于10
            this.beginPageIndex = 1;
            endPageIndex = pageCount;
        } else {//总页数大于10
            this.beginPageIndex = currentPage - 4;
            this.endPageIndex = currentPage + 5;

            //当前面的页码不足4个时，则显示前10个号码
            if (this.beginPageIndex < 1) {
                this.beginPageIndex = 1;
                this.endPageIndex = 10;
            }

            //当后面页码不足5个时，则显示后10个页码
            if (this.endPageIndex > this.pageCount) {
                this.endPageIndex = this.pageCount;
                this.beginPageIndex = this.pageCount - 10 + 1;
            }
        }
    }
}
