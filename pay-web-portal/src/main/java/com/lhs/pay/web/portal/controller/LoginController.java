package com.lhs.pay.web.portal.controller;

import com.google.code.kaptcha.Constants;
import com.google.common.base.Strings;
import com.lhs.pay.common.config.PublicConfig;
import com.lhs.pay.common.enums.ArticleTypeEnum;
import com.lhs.pay.common.enums.PublicStatusEnum;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.entity.UserOperator;
import com.lhs.pay.facade.user.enums.UserOperatorTypeEnum;
import com.lhs.pay.facade.user.exceptions.UserBizException;
import com.lhs.pay.facade.user.service.UserManagementFacade;
import com.lhs.pay.facade.user.service.UserOperatorFacade;
import com.lhs.pay.web.portal.base.BaseConsts;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * LoginController
 *
 * @author longhuashen
 * @since 16/5/29
 */
@Controller
public class LoginController {

    @Autowired
    private UserManagementFacade userManagementFacade;

    @Autowired
    private UserOperatorFacade userOperatorFacade;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("userType", "merchant");
        modelMap.put("type", ArticleTypeEnum.NOTICE.getValue());//通知、公告
        modelMap.put("status", PublicStatusEnum.ACTIVE.getValue());
        modelMap.put("articleType", 1);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("userType") String userType,
                        @RequestParam("loginName") String loginName,
                        @RequestParam("randomCode") String randomcode,
                        @RequestParam("loginPwd") String password,
                        HttpServletRequest request,
                        ModelMap modelMap) {
        String kaptchaCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!"false".equals(randomcode)) {
            if (Strings.isNullOrEmpty(kaptchaCode)) {
                modelMap.put("loginMsg", "请输入验证码");
                modelMap.put("userType", userType);
                modelMap.put("loginName", loginName);
                return "login";
            } else if (!kaptchaCode.equalsIgnoreCase(kaptchaCode)) {
                modelMap.put("loginMsg", "验证码错误");
                modelMap.put("userType", userType);
                modelMap.put("loginName", loginName);
                return "login";
            }
        }


        String returnStr = "loginUI";

        UserOperator userOperator = null;

        //用户登录
        if ("merchant".equals(userType)) {
            try {
                UserInfo userInfo = userManagementFacade.merchantLogin(loginName, DigestUtils.sha1Hex(password), PublicConfig.PWD_ERROR_LIMIT_TIMES, PublicConfig.PWD_ERROR_LIMIT_TIME);
                userOperator = userOperatorFacade.getUserOperatorByLoginName(loginName);

                //用户信息
                request.getSession().setAttribute(BaseConsts.CURRENT_USER, userInfo);

                //操作员信息
                request.getSession().setAttribute(BaseConsts.CURRENT_USER_OPERATOR, userOperator);

                String redirectUrl = (String) request.getSession().getAttribute(BaseConsts.MERCHANT_REDIRECT_URL);
                if (!Strings.isNullOrEmpty(redirectUrl)) {
                    return BaseConsts.MERCHANT_REDIRECT_URL;
                }

                // 判断是否修改过登录密码,如果未修改，则去修改密码页面
                if (userOperator.getIsChangedPwd() == null || userOperator.getIsChangedPwd().intValue() == 0) {
                    if (userOperator.getType() == UserOperatorTypeEnum.USER.getValue()) {//操作员第一次登陆
                        returnStr = "firstEditLoginPwdUI";
                    } else {//管理员第一次登陆
                        returnStr = "firstEditLoginTradePwdUI";
                    }
                } else {
                    returnStr = "merchantIndex";
                }
            } catch (UserBizException e) {
                if (PublicConfig.PWD_TIMES_USE_KAPTCHA > 0) {//登陆错误次数加1
                    int times = 0;
                    if (request.getSession().getAttribute("LOGIN_TIMES_REACH") != "" && request.getSession().getAttribute("LOGIN_TIMES_REACH") != null) {
                        times = Integer.parseInt(request.getSession().getAttribute("LOGIN_TIMES_REACH") + "");
                    }
                    request.getSession().setAttribute("LOGIN_TIMES_REACH", times + 1);
                }
                modelMap.put("loginMsg", e.getMsg());
                modelMap.put("userType", userType);
                modelMap.put("loginName", loginName);
                return returnStr;
            }
        }

        if(!Strings.isNullOrEmpty(returnStr)) {
            return returnStr;
        }

        return "login";
    }
}
