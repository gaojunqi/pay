package com.lhs.pay.core.user.biz;

import com.lhs.pay.facade.user.entity.UserOperator;

/**
 * IUserOperatorBiz
 *
 * @author longhuashen
 * @since 16/7/23
 */
public interface IUserOperatorBiz {

    UserOperator getUserOperatorByLoginName(String loginName);

}
