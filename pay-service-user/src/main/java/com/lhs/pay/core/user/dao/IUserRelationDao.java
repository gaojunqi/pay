package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserRelation;

/**
 * IUserRelationDao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IUserRelationDao extends BaseDao<UserRelation> {

    UserRelation getBy_parentUserNo_childUserNo(String parentUserNo, String childeUserNo);
}
