package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserAuditRecordRealName;

/**
 * IUserAuditRecordRealNameDao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IUserAuditRecordRealNameDao extends BaseDao<UserAuditRecordRealName> {

    /**
     * 根据userName和auditStatus查询数据
     *
     * @param userNo
     * @param auditStatus
     * @return
     */
    UserAuditRecordRealName getByUserNo_auditStatus(String userNo, Integer auditStatus);
}
