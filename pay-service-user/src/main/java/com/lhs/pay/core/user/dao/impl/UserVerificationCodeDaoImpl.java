package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserVerificationCodeDao;
import com.lhs.pay.facade.user.entity.UserVerificationCode;
import com.lhs.pay.facade.user.enums.UserVerificationCodeStatusEnum;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserVerificationCodeDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("userVerificationCodeDao")
public class UserVerificationCodeDaoImpl extends BaseDaoImpl<UserVerificationCode> implements IUserVerificationCodeDao {

    @Override
    public List<UserVerificationCode> listUserVerificationCodeByLoginName(String loginName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginName", loginName);
        paramMap.put("status", UserVerificationCodeStatusEnum.NOT.getValue());
        return super.listBy(paramMap);
    }
}
