package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserOperatorDao;
import com.lhs.pay.facade.user.entity.UserOperator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserOperatorDaoImpl
 *
 * @author longhuashen
 * @since 16/6/1
 */
@Repository("userOperatorDao")
public class UserOperatorDaoImpl extends BaseDaoImpl<UserOperator> implements IUserOperatorDao {

    @Override
    public UserOperator getByLoginName(String loginName) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", loginName);
        return super.getBy(map);
    }

    @Override
    public List<UserOperator> listByUserNo(String userNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        return super.listBy(map);
    }

    @Override
    public void updateUserOperatorStatusByUserNo(String userNo, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("status", status);
        super.getSessionTemplate().update("updateUserOperatorStatusByUserNo", map);
    }

    @Override
    public void resetUserOperatorPassword(String loginName, String newPwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", loginName);
        map.put("status", newPwd);
        super.getSessionTemplate().update("resetUserOperatorPassword", map);
    }

    @Override
    public UserOperator getOperator_userNo_type(String userNo, int type) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("status", type);
        return super.getBy(map);
    }
}
