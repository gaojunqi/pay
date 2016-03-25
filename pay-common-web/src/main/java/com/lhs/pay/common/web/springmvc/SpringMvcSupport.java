package com.lhs.pay.common.web.springmvc;

/**
 * SpringMvcSupport
 *
 * @author longhuashen
 * @since 16/3/19
 */
public class SpringMvcSupport {

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
}
