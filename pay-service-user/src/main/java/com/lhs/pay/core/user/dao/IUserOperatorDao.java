package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserOperator;

import java.util.List;

/**
 * IUserOperatorDao
 *
 * @author longhuashen
 * @since 16/6/1
 */
public interface IUserOperatorDao extends BaseDao<UserOperator> {

    /**
     * 根据登陆名获取操作员信息
     *
     * @param loginName
     * @return
     */
    UserOperator getByLoginName(String loginName);

    /**
     * 根据用户编号列出该用户的所有操作员
     *
     * @param userNo
     * @return
     */
    List<UserOperator> listByUserNo(String userNo);

    /**
     * 根据用户编号，修改该用户下所有操作员信息
     *
     * @param userNo
     * @param status
     */
    void updateUserOperatorStatusByUserNo(String userNo, int status);

    /**
     * 重置操作员密码
     *
     * @param loginName 登录名
     * @param newPwd 新密码-加密后的数据
     */
    void resetUserOperatorPassword(String loginName, String newPwd);

    /**
     * 根据商户编号和类型查询操作员表
     *
     * @param userNo
     * @param type
     * @return
     */
    UserOperator getOperator_userNo_type(String userNo, int type);
}
