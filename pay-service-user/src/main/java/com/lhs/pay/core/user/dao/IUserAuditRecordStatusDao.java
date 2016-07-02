package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserAuditRecordStatus;

/**
 * IUserAuditRecordStatusDao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IUserAuditRecordStatusDao extends BaseDao<UserAuditRecordStatus> {

    UserAuditRecordStatus getByUserNo_auditStatus(String userNo, Integer auditStatus);
}
