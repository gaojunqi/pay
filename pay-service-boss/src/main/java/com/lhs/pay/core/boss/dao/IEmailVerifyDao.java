package com.lhs.pay.core.boss.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.boss.entity.EmailVerify;

import java.util.Map;

/**
 * IEmailVerifyDao
 *
 * @author longhuashen
 * @since 16/9/19
 */
public interface IEmailVerifyDao extends BaseDao<EmailVerify> {

    EmailVerify getByToken(String token);

    int updateStatus(Map<String, Object> paramMap);
}
