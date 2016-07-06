package com.lhs.pay.web.portal.controller.member;

import com.lhs.pay.common.enums.PublicStatusEnum;
import com.lhs.pay.facade.account.entity.Account;
import com.lhs.pay.facade.account.enums.AccountStatusEnum;
import com.lhs.pay.facade.account.service.AccountQueryFacade;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.service.MemberInfoFacade;
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

//    @Autowired
//    private MemberInfoFacade memberInfoFacade;

//    private UserQueryFacade userQueryFacade;

    @RequestMapping(value = "/viewAccount", method = RequestMethod.GET)
    public String viewAccount(HttpServletRequest request, ModelMap modelMap) {
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute(BaseConsts.CURRENT_USER);
        Account account = accountQueryFacade.getAccountByUserNo(userInfo.getAccountNo());

//        modelMap.put("availableBalance", )
//        modelMap.put("account", account);

//        //账户状态
//        modelMap.put("accountStatusEnum", AccountStatusEnum.values());
//
//        //积分
////        modelMap.put("loginScore", )
//        modelMap.put("accountStatusList", AccountStatusEnum.values());
//        modelMap.put("lastLoginDate", request.getSession().getAttribute(BaseConsts.CURRENT_USER_OPERATOR));
//        modelMap.put("member", userInfo.getUserNo());
//        modelMap.put("PublicStatusEnum", PublicStatusEnum.values());
        return "merchant/account/accountView";
    }
}
