package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsRoleOperator;

import java.util.List;

/**
 * IPmsRoleOperatorDao
 *
 * @author longhuashen
 * @since 16/4/9
 */
public interface IPmsRoleOperatorDao extends BaseDao<PmsRoleOperator> {

    /**
     * 根据操作员ID查找该操作员关联的角色
     *
     * @param operatorId
     * @return
     */
    List<PmsRoleOperator> listByOperatorId(long operatorId);

    /**
     * 根据角色ID查找该操作员关联的操作员
     *
     * @param roleId
     * @return
     */
    List<PmsRoleOperator> listByRoleId(long roleId);

    /**
     * 根据操作员ID删除与角色的关联记录
     *
     * @param operarotId
     */
    void deleteByOperatorId(long operarotId);

    /**
     * 根据角色ID删除操作员与角色的关联关系
     *
     * @param roleId
     */
    void deleteByRoleId(long roleId);

    /**
     * 根据角色ID和操作员ID删除关联数据
     *
     * @param roleId
     * @param operatorId
     */
    void deleteByRoleIdAndOperatorId(long roleId, long operatorId);
}
