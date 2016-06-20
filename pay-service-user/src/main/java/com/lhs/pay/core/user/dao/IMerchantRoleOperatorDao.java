package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.MerchantRoleOperator;

import java.util.List;

/**
 * IMerchantRoleOperatorDao
 *
 * @author longhuashen
 * @since 16/6/20
 */
public interface IMerchantRoleOperatorDao extends BaseDao<MerchantRoleOperator> {

    /**
     * 根据角色ID删除角色信息
     *
     * @param roleId
     */
    void deleteByRoleId(Long roleId);

    /**
     * 根据角色ID查找该操作员关联的角色
     *
     * @param operatorId
     * @return
     */
    List<MerchantRoleOperator> listByOperatorId(long operatorId);

    /**
     * 根据角色ID和操作员ID获取角色关联表
     *
     * @param roleId
     * @param operatorId
     * @return
     */
    MerchantRoleOperator getByRoleIdAndOperatorId(Long roleId, Long operatorId);

    List listByRoleId(long roleId);

    /**
     * 保存角色操作员
     *
     * @param operatorId
     * @param roleOpratorStr
     */
    void saveRoleOperator(Long operatorId, String roleOpratorStr);

    /**
     * 保存角色权限
     *
     * @param roleIdStr
     * @param operatorIdsStr
     */
    void saveRoleOperators(String roleIdStr, String operatorIdsStr);
}
