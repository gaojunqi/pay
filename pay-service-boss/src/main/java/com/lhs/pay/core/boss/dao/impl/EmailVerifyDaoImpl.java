package com.lhs.pay.core.boss.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.boss.dao.IEmailVerifyDao;
import com.lhs.pay.facade.boss.entity.EmailVerify;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * EmailVerifyDaoImpl
 *
 * @author longhuashen
 * @since 16/9/19
 */
@Repository("emailVerifyDao")
public class EmailVerifyDaoImpl extends BaseDaoImpl<EmailVerify> implements IEmailVerifyDao {

    @Override
    public EmailVerify getByToken(String token) {
        return super.getSessionTemplate().selectOne(getStatement("getByToken"), token);
    }

    @Override
    public int updateStatus(Map<String, Object> paramMap) {
        return super.getSessionTemplate().update(getStatement("updateStatus"), paramMap);
    }
}
