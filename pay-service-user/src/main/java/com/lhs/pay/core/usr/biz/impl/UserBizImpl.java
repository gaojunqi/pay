package com.lhs.pay.core.usr.biz.impl;

import com.lhs.pay.core.user.dao.IUserOperatorDao;
import com.lhs.pay.core.usr.biz.IUserBiz;
import com.lhs.pay.facade.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserBizImpl
 *
 * @author longhuashen
 * @since 16/6/1
 */
@Service("userBiz")
public class UserBizImpl implements IUserBiz {

    @Autowired
    private IUserOperatorDao userOperatorDao;

    @Override
    public UserInfo merchantLogin(String loginName, String loginPwd, Integer pwdErrMaxTimes, Integer validMinute) {
        return null;
    }
}
