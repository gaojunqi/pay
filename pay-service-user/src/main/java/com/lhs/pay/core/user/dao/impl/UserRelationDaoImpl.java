package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserRelationDao;
import com.lhs.pay.facade.user.entity.UserRelation;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * UserRelationDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("userRelationDao")
public class UserRelationDaoImpl extends BaseDaoImpl<UserRelation> implements IUserRelationDao {

    @Override
    public UserRelation getBy_parentUserNo_childUserNo(String parentUserNo, String childeUserNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("parentUserNo", parentUserNo);
        paramMap.put("childUserNo", childeUserNo);
        return super.getBy(paramMap);
    }
}
