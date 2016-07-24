package com.lhs.pay.core.user.biz.impl;

import com.lhs.pay.core.user.biz.IUserOperatorBiz;
import com.lhs.pay.core.user.dao.IUserOperatorDao;
import com.lhs.pay.facade.user.entity.UserOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserOperatorBizImpl
 *
 * @author longhuashen
 * @since 16/7/23
 */
@Service("userOperatorBiz")
public class UserOperatorBizImpl implements IUserOperatorBiz {

    @Autowired
    private IUserOperatorDao userOperatorDao;

    @Override
    public UserOperator getUserOperatorByLoginName(String loginName) {
        return userOperatorDao.getByLoginName(loginName);
    }
}
