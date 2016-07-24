package com.lhs.pay.facade.user.service.impl;

import com.lhs.pay.core.user.biz.IUserOperatorBiz;
import com.lhs.pay.facade.user.entity.UserOperator;
import com.lhs.pay.facade.user.service.UserOperatorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserOperatorFacadeImpl
 *
 * @author longhuashen
 * @since 16/7/23
 */
@Service("userOperatorFacade")
public class UserOperatorFacadeImpl implements UserOperatorFacade {

    @Autowired
    private IUserOperatorBiz userOperatorBiz;

    @Override
    public UserOperator getUserOperatorByLoginName(String loginName) {
        return userOperatorBiz.getUserOperatorByLoginName(loginName);
    }
}
