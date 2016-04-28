package com.lhs.pay.common.web.springmvc;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.common.web.dwz.DwzParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
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
    public String operateError(String message, ModelMap modelMap, HttpServletRequest req) {
        //ajaxDone("300", message);
        DwzParam param = getDwzParam("300", message, req);
        modelMap.put("message", message);
        return "operateError";
    }

    /**
     * 根据request对象，获取页面提交过来的DWZ框架的AjaxDone响应参数值.
     *
     * @author WuShuicheng.
     * @param statusCode
     *            状态码.
     * @param message
     *            操作结果提示消息.
     * @return DwzParam :封装好的DwzParam对象 .
     */
    public DwzParam getDwzParam(String statusCode, String message, HttpServletRequest req) {
        // 获取DWZ Ajax响应参数值,并构造成参数对象
        String navTabId = req.getParameter("navTabId");
        String dialogId = req.getParameter("dialogId");
        String callbackType = req.getParameter("callbackType");
        String forwardUrl = req.getParameter("forwardUrl");
        String rel = req.getParameter("rel");
        return new DwzParam(statusCode, message, navTabId, dialogId, callbackType, forwardUrl, rel, null);
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
