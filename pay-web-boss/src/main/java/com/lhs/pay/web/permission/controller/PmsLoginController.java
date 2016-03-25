package com.lhs.pay.web.permission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PmsLoginController
 *
 * @author longhuashen
 * @since 16/3/19
 */
@Controller
public class PmsLoginController {

    /**
     * 进入登陆页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }
}
