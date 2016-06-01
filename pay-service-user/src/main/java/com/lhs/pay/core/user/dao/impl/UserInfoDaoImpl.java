package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserInfoDao;
import com.lhs.pay.facade.user.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserInfoDaoImpl
 *
 * @author longhuashen
 * @since 16/6/1
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements IUserInfoDao {

    @Override
    public UserInfo getUserInfoByBindEmail(String bindEmail) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bindEmail", bindEmail);
        return super.getBy(paramMap);
    }

    @Override
    public UserInfo getUserInfoByBindMobileNo(String bindMobileNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bindMobileNo", bindMobileNo);
        return super.getBy(paramMap);
    }

    @Override
    public UserInfo getUserInfoByUserNo(String userNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        return super.getBy(paramMap);
    }

    @Override
    public UserInfo getUserInfoByAccountNo(String accountNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNo", accountNo);
        return super.getBy(paramMap);
    }

    @Override
    public UserInfo getUserInfoByLoginName(String loginName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginName", loginName);
        return super.getBy(paramMap);
    }

    @Override
    public String buildUserNo(String mcc) {
        String userNoSeq = super.getSeqNextValue("USER_NO_SEQ");
        return "888" + userNoSeq.substring(0, 4) + mcc + userNoSeq.substring(4, 8);
    }

    @Override
    public int updateUserInfoStatusAndIsRealName(String userNo, int changeStatus, int isRealNameAuth) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("status", changeStatus);
        paramMap.put("isRealNameAuth", isRealNameAuth);
        return this.getSqlSession().update("updateUserInfoStatusAndIsRealName", paramMap);
    }

    @Override
    public UserInfo getUserInfoByCardNo(String cardNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cardNo", cardNo);
        return super.getBy(paramMap);
    }

    @Override
    public List<UserInfo> likeBy(String userNoKey) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNoKey", userNoKey);
        return super.getSessionTemplate().selectList(getStatement("likeBy"), paramMap);
    }
}
