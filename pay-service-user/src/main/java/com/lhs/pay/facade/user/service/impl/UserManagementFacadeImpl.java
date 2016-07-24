package com.lhs.pay.facade.user.service.impl;

import com.alibaba.dubbo.rpc.RpcException;
import com.lhs.pay.core.user.biz.IUserBiz;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.exceptions.UserBizException;
import com.lhs.pay.facade.user.service.UserManagementFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserManagementFacadeImpl
 *
 * @author longhuashen
 * @since 16/6/1
 */
@Service("userManagementFacade")
public class UserManagementFacadeImpl implements UserManagementFacade {

    @Autowired
    private IUserBiz userBiz;

    @Override
    public void registerMember(String loginName, String loginPwd, String payPwd, String question, String answer, String greeting, String realName, String cardNo, String fax, String qq, String telNo, String address) throws UserBizException, RpcException {

    }

    @Override
    public UserInfo memberLogin(String loginName, String loginPwd, Integer pwdErrMaxTimes, Integer validMinute) throws UserBizException, RpcException {
        return null;
    }

    @Override
    public void registerMerchant(String loginName, String loginPwd, String question, String answer, String greeting, String bindMobileNo, Integer userType, Integer merchantType, String fullName, String shortName, String licenseNo, String url, String icp, String busiContactName, String busiContactMobileNo, String scope, String province, String city, String area, String address, String legalPerson, String cardNo) throws UserBizException, RpcException {

    }

    @Override
    public UserInfo merchantLogin(String loginName, String loginPwd, Integer pwdErrMaxTimes, Integer validMinute) throws UserBizException, RpcException {
        return userBiz.merchantLogin(loginName, loginPwd, pwdErrMaxTimes, validMinute);
    }
}
