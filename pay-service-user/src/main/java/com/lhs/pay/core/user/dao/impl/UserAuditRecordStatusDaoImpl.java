package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserAuditRecordStatusDao;
import com.lhs.pay.facade.user.entity.UserAuditRecordStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * UserAuditRecordStatusDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
public class UserAuditRecordStatusDaoImpl extends BaseDaoImpl<UserAuditRecordStatus> implements IUserAuditRecordStatusDao {

    @Override
    public UserAuditRecordStatus getByUserNo_auditStatus(String userNo, Integer auditStatus) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("auditStatus", auditStatus);
        return super.getBy(map);
    }
}
