package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsRoleMenu;

import java.util.List;

/**
 * IPmsRoleMenuDao
 *
 * @author longhuashen
 * @since 16/4/20
 */
public interface IPmsRoleMenuDao extends BaseDao<PmsRoleMenu> {

    /**
     * 根据角色ID删除菜单与角色关联关系
     *
     * @param roleId
     */
    void deleteByRoleId(Long roleId);

    /**
     * 根据角色ID统计关联到此角色的菜单数
     *
     * @param roleId
     * @return
     */
    List<PmsRoleMenu> listByRoleId(Long roleId);
}
