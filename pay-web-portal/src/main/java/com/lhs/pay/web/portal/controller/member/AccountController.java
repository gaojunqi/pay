package com.lhs.pay.web.portal.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AccountController
 *
 * @author longhuashen
 * @since 16/5/17
 */
@Controller
@RequestMapping("/merchant/account")
public class AccountController {

    @RequestMapping(value = "/viewAccount", method = RequestMethod.GET)
    public String viewAccount() {

        return "merchant/account/accountView";
    }
}
