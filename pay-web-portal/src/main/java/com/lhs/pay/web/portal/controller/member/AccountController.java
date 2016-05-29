package com.lhs.pay.web.portal.controller.member;

import com.lhs.pay.facade.account.service.AccountQueryFacade;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.web.portal.base.BaseConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * AccountController
 *
 * @author longhuashen
 * @since 16/5/17
 */
@Controller
@RequestMapping("/merchant/account")
public class AccountController {


    @Autowired
    private AccountQueryFacade accountQueryFacade;

    @RequestMapping(value = "/viewAccount", method = RequestMethod.GET)
    public String viewAccount(HttpServletRequest request, ModelMap modelMap) {
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute(BaseConsts.CURRENT_USER);
//        Account account = accountQueryFacade.getAccountByUserNo(userInfo.getAccountNo());
//
//        modelMap.put("account", account);
//        modelMap.put("accountStatusEnum", AccountStatusEnum.values());
//        modelMap.put("loginScore", )
        return "merchant/account/accountView";
    }
}
