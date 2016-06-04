package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserAuditRecordCloseDao;
import com.lhs.pay.facade.user.entity.UserAuditRecordClose;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * UserAuditRecordCloseDaoImpl
 *
 * @author longhuashen
 * @since 16/6/4
 */
@Repository("userAuditRecordCloseDao")
public class UserAuditRecordCloseDaoImpl extends BaseDaoImpl<UserAuditRecordClose> implements IUserAuditRecordCloseDao {

    @Override
    public UserAuditRecordClose getByUserNo_auditStatus(String userNo, Integer auditStatus) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("auditStatus", auditStatus);
        return super.getBy(paramMap);
    }
}
