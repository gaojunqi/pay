package com.lhs.pay.web.portal.listener;

import com.lhs.pay.common.config.PublicConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * ContextLoaderInit
 *
 * @author longhuashen
 * @since 16/5/29
 */
public class ContextLoaderInit extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletContext context = this.getServletContext();
        //设置全局参数
        context.setAttribute("IS_USE_KAPTCHA", PublicConfig.IS_USE_KAPTCHA);
        context.setAttribute("PWD_TIMES_USE_KAPTCHA", PublicConfig.PWD_TIMES_USE_KAPTCHA);

        //是否启用CFCA密码盘键  不能删除
        context.setAttribute("USE_KEYBOARD", PublicConfig.USE_KEYBOARD);
        //是否启用CFCA数字证书  不能删除
        context.setAttribute("USE_SECURITYCENTER", PublicConfig.USE_SECURITYCENTER);
        //是否启用SSL
        context.setAttribute("IS_SSL", PublicConfig.IS_SSL);
        //是否 是 域名 + 应用名
        context.setAttribute("IS_USE_DOMAIN_NAME", PublicConfig.IS_USE_DOMAIN_NAME);
        //公司信息
        context.setAttribute("COMPANY_NAME", PublicConfig.COMPANY_NAME);
        context.setAttribute("COMPANY_FOR", PublicConfig.COMPANY_FOR);
        context.setAttribute("COMPANY_LOGO", PublicConfig.COMPANY_LOGO);
        context.setAttribute("COMPANY_TEL", PublicConfig.COMPANY_TEL);
        context.setAttribute("COMPANY_ADDRESS", PublicConfig.COMPANY_ADDRESS);
        context.setAttribute("COMPANY_EMAIL", PublicConfig.COMPANY_EMAIL);
        context.setAttribute("COMPANY_NET_ICP", PublicConfig.COMPANY_NET_ICP);
        context.setAttribute("COMPANY_HR_EMAIL", PublicConfig.COMPANY_HR_EMAIL);
        context.setAttribute("PORTAL_IS_REGISTER", PublicConfig.PORTAL_IS_REGISTER);
        context.setAttribute("COMPANY_ABOUT_US", PublicConfig.COMPANY_ABOUT_US);
    }
}
