package com.lhs.pay.core.usr.biz;

import com.lhs.pay.facade.user.entity.UserInfo;

/**
 * IUserBiz
 *
 * @author longhuashen
 * @since 16/6/1
 */
public interface IUserBiz {

    /**
     * 商户登陆
     *
     * @param loginName 登陆名
     * @param loginPwd  登陆密码
     * @param pwdErrMaxTimes 密码错误次数限制
     * @param validMinute 密码多次输错后的账户锁定时间
     * @return
     */
    UserInfo merchantLogin(String loginName, String loginPwd, Integer pwdErrMaxTimes, Integer validMinute);
}
