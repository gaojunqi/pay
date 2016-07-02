package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserTradePwdDao;
import com.lhs.pay.facade.user.entity.UserTradePwd;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * UserTradePwdDaoImpl
 *
 * 用户交易密码表数据访问层接口实现
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("userTradePwdDao")
public class UserTradePwdDaoImpl extends BaseDaoImpl<UserTradePwd> implements IUserTradePwdDao {

    @Override
    public UserTradePwd getByLoginName(String loginName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginName", loginName);
        return super.getBy(paramMap);
    }
}
