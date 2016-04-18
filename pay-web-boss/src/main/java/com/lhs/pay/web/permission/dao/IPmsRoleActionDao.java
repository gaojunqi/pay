package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsRole;
import com.lhs.pay.web.permission.entity.PmsRoleAction;

import java.util.List;

/**
 * IPmsRoleActionDao
 *
 * @author longhuashen
 * @since 16/4/18
 */
public interface IPmsRoleActionDao extends BaseDao<PmsRole> {

    /**
     * 根据角色ID找到角色关联的权限点
     *
     * @param roleId
     * @return
     */
    List<PmsRoleAction> listByRoleId(Long roleId);

    /**
     * 根据角色ID字符串获取相应角色-权限关联信息
     *
     * @param roleIdsStr
     * @return
     */
    List<PmsRoleAction> listByRoleIds(String roleIdsStr);

    /**
     * 根据权限ID查找角色-权限关联信息
     *
     * @param actionId
     * @return
     */
    List<PmsRoleAction> listByActionId(Long actionId);

    /**
     * 根据权限ID删除权限-角色关联关系
     *
     * @param actionId
     */
    void deleteByActionId(Long actionId);

    /**
     * 根据角色ID删除权限-角色关联关系
     *
     * @param roleId
     */
    void deleteByRoleId(Long roleId);
}
