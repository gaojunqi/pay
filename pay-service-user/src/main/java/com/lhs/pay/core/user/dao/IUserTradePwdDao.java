package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserTradePwd;

/**
 * IUserTradePwdDao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IUserTradePwdDao extends BaseDao<UserTradePwd> {

    /**
     * 根据登录名查询用户交易密码对象
     *
     * @param loginName
     * @return
     */
    UserTradePwd getByLoginName(String loginName);
}
