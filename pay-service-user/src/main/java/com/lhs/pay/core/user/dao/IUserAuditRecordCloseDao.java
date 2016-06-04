package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserAuditRecordClose;

/**
 * IUserAuditRecordCloseDao
 *
 * 用户注销审核表数据访问层接口
 *
 * @author longhuashen
 * @since 16/6/4
 */
public interface IUserAuditRecordCloseDao extends BaseDao<UserAuditRecordClose> {

    /**
     * 查询用户状态变更表
     *
     * @param userNo
     * @param auditStatus
     * @return
     */
    UserAuditRecordClose getByUserNo_auditStatus(String userNo, Integer auditStatus);
}
