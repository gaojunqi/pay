package com.lhs.pay.core.usr.biz.impl;

import com.google.common.base.Verify;
import com.lhs.pay.common.enums.OperatorStatusEnum;
import com.lhs.pay.core.user.dao.IUserAuditRecordCloseDao;
import com.lhs.pay.core.user.dao.IUserInfoDao;
import com.lhs.pay.core.user.dao.IUserOperatorDao;
import com.lhs.pay.core.usr.biz.IUserBiz;
import com.lhs.pay.facade.user.entity.UserAuditRecordClose;
import com.lhs.pay.facade.user.entity.UserInfo;
import com.lhs.pay.facade.user.entity.UserOperator;
import com.lhs.pay.facade.user.enums.UserAuditStatusEnum;
import com.lhs.pay.facade.user.enums.UserTypeEnum;
import com.lhs.pay.facade.user.exceptions.UserBizException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * UserBizImpl
 *
 * @author longhuashen
 * @since 16/6/1
 */
@Service("userBiz")
public class UserBizImpl implements IUserBiz {

    @Autowired
    private IUserOperatorDao userOperatorDao;

    @Autowired
    private IUserInfoDao userInfoDao;

    @Autowired
    private IUserAuditRecordCloseDao userAuditRecordCloseDao;

    @Override
    public UserInfo merchantLogin(String loginName, String loginPwd, Integer pwdErrMaxTimes, Integer validMinute) {
        //1.根据登陆名判断是否存在此操作员
        UserOperator userOperator = userOperatorDao.getByLoginName(loginName);

        if (userOperator == null) {
            throw new UserBizException(UserBizException.LOGIN_LOGNAME_NOT_EXIST, "用户名或密码错误");
        }

        //用户销户记录
        UserAuditRecordClose userAuditRecordClose = userAuditRecordCloseDao.getByUserNo_auditStatus(userOperator.getUserNo(), UserAuditStatusEnum.AGREE.getValue());

        Verify.verifyNotNull(userAuditRecordClose, "用户名或密码错误", loginName);

        //2.判断商户的状态
        if (OperatorStatusEnum.ACTIVE.getValue() == userOperator.getStatus()) {
            //判断是否存在商户
            UserInfo userInfo = userInfoDao.getUserInfoByUserNo(userOperator.getUserNo());
            if (userInfo == null) {
                throw new UserBizException(UserBizException.LOGIN_LOGNAME_NOT_EXIST, "用户名或密码错误");
            }
            int userType = userInfo.getUserType().intValue();
            if (userType != UserTypeEnum.MERCHANT.getValue() && userType != UserTypeEnum.POSAGENT.getValue()    ) {
                throw new UserBizException(UserBizException.LOGIN_LOGNAME_NOT_EXIST, "商户用户名或密码错误");
            }

            //判断登陆密码是否正确
            validLoginPwd(userOperator, loginPwd, pwdErrMaxTimes, validMinute);
            return userInfo;
        } else if (userAuditRecordClose != null) {
            throw new UserBizException(UserBizException.LOGIN_OPERATORSTATUS_CANCELLATION, "该用户已被注销，不能登录！");
        } else {
            throw new UserBizException(UserBizException.LOGIN_OPERATORSTATUS_INACTIVE, "该用户已被冻结，不能登录！");
        }
    }

    /**
     * 验证登录密码是否正确
     *
     * @param userOperator
     * @param loginPwd
     * @param pwdErrMaxTimes
     * @param lockMinute
     */
    private void validLoginPwd(UserOperator userOperator, String loginPwd, Integer pwdErrMaxTimes, Integer lockMinute) {
        if (userOperator.getPwdErrorTimes() == null) {
            userOperator.setPwdErrorLastTime(new Date());
        }

        if (new Date().before(new DateTime(userOperator.getPwdErrorLastTime()).plusMinutes(lockMinute).toDate())) {
            if (userOperator.getPwdErrorTimes() >= pwdErrMaxTimes) {
                throw new UserBizException(UserBizException.LOGIN_PWDERRORTIMES_OVERRUN, "密码错误次数超限");
            }
        } else {
            userOperator.setPwdErrorTimes(0);
        }

        if (userOperator.getLoginPwd().equals(loginPwd)) {
            userOperator.setPwdErrorTimes(0);
            userOperator.setPwdErrorLastTime(new Date());
            userOperatorDao.update(userOperator);
        } else {
            //只记录第一次错误时间
            if (userOperator.getPwdErrorTimes() == 0) {
                userOperator.setPwdErrorLastTime(new Date());
            }
            userOperator.setPwdErrorTimes(userOperator.getPwdErrorTimes() + 1);
            userOperatorDao.update(userOperator);

            if (pwdErrMaxTimes - userOperator.getPwdErrorTimes() == 0) {
                throw new UserBizException(UserBizException.LOGIN_PWD_ERROR, "登录密码错误，已被锁定");
            } else {
                throw new UserBizException(UserBizException.LOGIN_PWD_ERROR, "登录密码错误，还有%s次机会.", pwdErrMaxTimes - userOperator.getPwdErrorTimes());
            }
        }
    }
}
