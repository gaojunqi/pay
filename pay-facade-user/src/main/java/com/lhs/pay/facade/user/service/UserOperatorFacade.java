package com.lhs.pay.facade.user.service;

import com.lhs.pay.facade.user.entity.UserOperator;
import com.lhs.pay.facade.user.exceptions.UserBizException;

/**
 * UserOperatorFacade
 *
 * @author longhuashen
 * @since 16/7/23
 */
public interface UserOperatorFacade {

    /**
     * 根据登录名获取用户操作员信息
     *
     * @param loginName
     * @return
     * @throws UserBizException
     */
    UserOperator getUserOperatorByLoginName(String loginName) throws UserBizException;
}
