package com.lhs.pay.common.web.springmvc;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringMvcSupport
 *
 * @author longhuashen
 * @since 16/3/19
 */
public class SpringMvcSupport {

    public PageBean pageBean;

    public Integer pageNum;

    /**
     * 响应DWZ的ajax失败请求(statusCode="300", 跳转到ajaxDone视图)
     *
     * @param message
     * @return
     */
    public String operateError(String message) {
        //ajaxDone("300", message);
        return "operateError";
    }

    public PageParam getPageParam() {
        return new PageParam(getPageNum(), getNumPerPage());
    }

    private int getNumPerPage() {
        HttpServletRequest request =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String numPerPageStr =  request.getParameter("numPerPage");
        int numPerPage = 20;
        if (StringUtils.isNotBlank(numPerPageStr)) {
            numPerPage = Integer.parseInt(numPerPageStr);
        }
        return numPerPage;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
