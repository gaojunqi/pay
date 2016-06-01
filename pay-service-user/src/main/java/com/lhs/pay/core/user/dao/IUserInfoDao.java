package com.lhs.pay.core.user.dao;

import com.lhs.pay.facade.user.entity.UserInfo;

import java.util.List;

/**
 * IUserInfoDao
 *
 * @author longhuashen
 * @since 16/6/1
 */
public interface IUserInfoDao {

    /**
     * 根据绑定邮箱查询用户信息
     *
     * @param bindEmail
     * @return
     */
    UserInfo getUserInfoByBindEmail(String bindEmail);

    /**
     * 根据绑定手机号码查询用户信息
     *
     * @param bindMobileNo
     * @return
     */
    UserInfo getUserInfoByBindMobileNo(String bindMobileNo);

    /**
     * 根据账户编号查询用户信息
     *
     * @param userNo
     * @return
     */
    UserInfo getUserInfoByUserNo(String userNo);

    /**
     * 根据账户编号查询用户信息
     *
     * @param accountNo
     * @return
     */
    UserInfo getUserInfoByAccountNo(String accountNo);


    /**
     * 根据登录名查询用户信息
     *
     * @param loginName
     * @return
     */
    UserInfo getUserInfoByLoginName(String loginName);


    /**
     * 生成15位用户编号(在线和POS统一引此方法)
     *
     * @param mcc
     * @return
     */
    String buildUserNo(String mcc);

    /**
     * 更新用户状态，并标记用户为已实名认证
     *
     * @param userNo
     * @param changeStatus
     * @param isRealNameAuth
     * @return
     */
    int updateUserInfoStatusAndIsRealName(String userNo, int changeStatus, int isRealNameAuth);

    /**
     * 检验法人身份证号是否存在
     *
     * @param cardNo
     * @return
     */
    UserInfo getUserInfoByCardNo(String cardNo);

    /**
     * 根据UserNo模糊查找
     *
     * @param userNoKey
     * @return
     */
    List<UserInfo> likeBy(String userNoKey);
}
