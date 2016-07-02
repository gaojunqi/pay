package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserVerificationCode;

import java.util.List;

/**
 * IUserVerificationCodeDao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IUserVerificationCodeDao extends BaseDao<UserVerificationCode> {

    List<UserVerificationCode> listUserVerificationCodeByLoginName(String loginName);
}
