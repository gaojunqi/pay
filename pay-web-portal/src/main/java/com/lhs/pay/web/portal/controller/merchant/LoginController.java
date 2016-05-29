package com.lhs.pay.web.portal.controller.merchant;

import com.google.code.kaptcha.Constants;
import com.lhs.pay.common.enums.ArticleTypeEnum;
import com.lhs.pay.common.enums.PublicStatusEnum;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.entity.UserOperator;
import com.lhs.pay.facade.user.service.UserManagementFacade;
import org.apache.logging.log4j.util.Strings;
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

//    @Autowired
//    private UserManagementFacade userManagementFacade;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("userType", "merchant");
        modelMap.put("type", ArticleTypeEnum.NOTICE.getValue());
        modelMap.put("status", PublicStatusEnum.ACTIVE.getValue());
        modelMap.put("articleType", 1);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("userType") String userType,
                        @RequestParam("userType") String loginName,
                        @RequestParam("userType") String randomcode,
                        HttpServletRequest request,
                        ModelMap modelMap) {
        String kaptchaCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!"flase".equals(randomcode)) {
            if (Strings.isBlank(kaptchaCode)) {
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

        UserOperator userOperator = null;

        if ("merchant".equals(userType)) {
//            UserInfo userInfo = userManagementFacade.
        }
        return "login";
    }
}
