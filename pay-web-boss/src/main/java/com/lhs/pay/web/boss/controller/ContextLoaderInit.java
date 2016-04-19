package com.lhs.pay.web.boss.controller;

import com.lhs.pay.common.config.PublicConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * ContextLoaderInit
 *
 * 初始化系统平台参数
 *
 * @author longhuashen
 * @since 16/4/8
 */
public class ContextLoaderInit extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletContext context = this.getServletContext();
        //设置全局参数
        context.setAttribute("IS_SSL", PublicConfig.IS_SSL);
        //门户URL地址
        context.setAttribute("PROTAL_URL", PublicConfig.PORTAL_URL);
        //公司信息
        context.setAttribute("COMPANY_NAME", PublicConfig.COMPANY_NAME);
        context.setAttribute("COMPANY_FOR", PublicConfig.COMPANY_FOR);
        context.setAttribute("COMPANY_LOGO", PublicConfig.COMPANY_LOGO);
        context.setAttribute("COMPANY_TEL", PublicConfig.COMPANY_TEL);
        context.setAttribute("COMPANY_ADDRESS", PublicConfig.COMPANY_ADDRESS);
        context.setAttribute("COMPANY_EMAIL", PublicConfig.COMPANY_EMAIL);
        context.setAttribute("COMPANY_NET_ICP", PublicConfig.COMPANY_NET_ICP);
        context.setAttribute("COMPANY_HR_EMAIL", PublicConfig.COMPANY_HR_EMAIL);
        context.setAttribute("COMPANY_HR_EMAIL", PublicConfig.COMPANY_HR_EMAIL);

        //是 否 域名+应用名
        context.setAttribute("IS_USE_DOMAIN_NAME", PublicConfig.IS_USE_DOMAIN_NAME);
        context.setAttribute("FILE_SYS_URL", PublicConfig.FILE_SYS_URL);

    }
}
