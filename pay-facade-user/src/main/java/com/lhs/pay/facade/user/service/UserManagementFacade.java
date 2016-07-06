package com.lhs.pay.facade.user.service;

import com.alibaba.dubbo.rpc.RpcException;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.exceptions.UserBizException;

/**
 * UserManagementFacade
 *
 * @author longhuashen
 * @since 16/5/29
 */
public interface UserManagementFacade {

    /**
     * 会员信息注册
     *
     * @param loginName 登录名
     * @param loginPwd  登陆密码
     * @param payPwd    支付密码
     * @param question  安全保护问题
     * @param answer    安全保护答案
     * @param greeting  预留信息
     * @param realName  真实姓名
     * @param cardNo    身份证号
     * @param fax       传真号
     * @param qq        QQ号
     * @param telNo     联系电话
     * @param address   地址
     * @throws UserBizException
     * @throws RpcException
     */
    void registerMember(String loginName,
                        String loginPwd,
                        String payPwd,
                        String question,
                        String answer,
                        String greeting,
                        String realName,
                        String cardNo,
                        String fax,
                        String qq,
                        String telNo,
                        String address) throws UserBizException, RpcException;

    /**
     * 会员登陆
     *
     * @param loginName
     * @param loginPwd
     * @param pwdErrMaxTimes
     * @param validMinute
     * @return
     * @throws UserBizException
     * @throws RpcException
     */
    UserInfo memberLogin(String loginName,
                         String loginPwd,
                         Integer pwdErrMaxTimes,
                         Integer validMinute) throws UserBizException, RpcException;

    /**
     * 在线支付的商户注册
     *
     * @param loginName
     * @param loginPwd
     * @param question
     * @param answer
     * @param greeting
     * @param bindMobileNo
     * @param userType
     * @param merchantType
     * @param fullName
     * @param shortName
     * @param licenseNo
     * @param url
     * @param icp
     * @param busiContactName
     * @param busiContactMobileNo
     * @param scope
     * @param province
     * @param city
     * @param area
     * @param address
     * @param legalPerson
     * @param cardNo
     * @throws UserBizException
     * @throws RpcException
     */
    void registerMerchant(String loginName,
                          String loginPwd,
                          String question,
                          String answer,
                          String greeting,
                          String bindMobileNo,
                          Integer userType,
                          Integer merchantType,
                          String fullName,
                          String shortName,
                          String licenseNo,
                          String url,
                          String icp,
                          String busiContactName,
                          String busiContactMobileNo,
                          String scope,
                          String province,
                          String city,
                          String area,
                          String address,
                          String legalPerson,
                          String cardNo) throws UserBizException, RpcException;

    /**
     * 商户登录
     *
     * @param loginName
     * @param loginPwd
     * @param pwdErrMaxTimes
     * @param validMinute
     * @return
     * @throws UserBizException
     * @throws RpcException
     */
    UserInfo merchantLogin(String loginName, String loginPwd, Integer pwdErrMaxTimes, Integer validMinute) throws UserBizException, RpcException;
}
