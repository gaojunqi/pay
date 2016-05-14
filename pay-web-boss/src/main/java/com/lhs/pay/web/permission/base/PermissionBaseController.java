package com.lhs.pay.web.permission.base;

import com.lhs.pay.common.web.springmvc.SpringMvcSupport;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * PermissionBaseController
 *
 * @author longhuashen
 * @since 16/3/19
 */
public class PermissionBaseController extends SpringMvcSupport {

    /**
     * 对于需要转换为Date类型的属性，使用DateEditor进行处理
     *
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
