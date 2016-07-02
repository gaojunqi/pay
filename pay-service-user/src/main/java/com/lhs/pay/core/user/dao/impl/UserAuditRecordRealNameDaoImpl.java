package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserAuditRecordRealNameDao;
import com.lhs.pay.facade.user.entity.UserAuditRecordRealName;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * UserAuditRecordRealNameDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("userAuditRecordRealNameDao")
public class UserAuditRecordRealNameDaoImpl extends BaseDaoImpl<UserAuditRecordRealName> implements IUserAuditRecordRealNameDao {

    @Override
    public UserAuditRecordRealName getByUserNo_auditStatus(String userNo, Integer auditStatus) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("auditStatus", auditStatus);
        return super.getBy(paramMap);
    }
}
