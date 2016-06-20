package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.MerchantRoleAction;

import java.util.List;

/**
 * IMerchantRoleActionDao
 *
 * @author longhuashen
 * @since 16/6/20
 */
public interface IMerchantRoleActionDao extends BaseDao<MerchantRoleAction> {

    /**
     * 根据权限ID删除
     *
     * @param actionId
     */
    void deleteByActionId(long actionId);

    /**
     * 根据角色ID找到角色关联的权限点.
     *
     * @param roleId
     * @return
     */
    List<MerchantRoleAction> listMerchantRoleActionByRoleId(long roleId);

    /**
     * 根据角色ID字符串获取角色权限关联信息
     *
     * @param roleIdStr
     * @return
     */
    List<MerchantRoleAction> listByRoleIds(String roleIdStr);

    /**
     * 保存角色的操作权限
     *
     * @param roleId
     * @param actionStr
     */
    void saveRoleAction(Long roleId, String actionStr);
}
