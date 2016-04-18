package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsOperator;

import java.util.List;

/**
 * IPmsOperatorDao
 *
 * @author longhuashen
 * @since 16/4/9
 */
public interface IPmsOperatorDao extends BaseDao<PmsOperator> {

    /**
     * 根据登录名获取操作员对象
     *
     * @param loginName
     * @return
     */
    PmsOperator findByLoginName(String loginName);

    /**
     * 根据角色id找到操作员列表
     *
     * @param roleId
     * @return
     */
    List<PmsOperator> listByRoleId(long roleId);
}
