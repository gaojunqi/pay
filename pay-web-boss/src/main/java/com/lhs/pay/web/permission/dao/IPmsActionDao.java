package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsAction;

import java.util.List;

/**
 * IPmsActionDao
 *
 * @author longhuashen
 * @since 16/4/18
 */
public interface IPmsActionDao extends BaseDao<PmsAction> {

    /**
     * 根据实体ID集字符串获取对象列表
     *
     * @param idStr
     * @return
     */
    List<PmsAction> findByIds(String idStr);

    /**
     * 根据权限名称查找权限
     *
     * @param actionName
     * @return
     */
    PmsAction getByActionName(String actionName);

    /**
     * 根据权限标识查找权限
     *
     * @param action
     * @return
     */
    PmsAction getByAction(String action);

    /**
     * 检查修改后的权限名是否会与其他权限名冲突
     *
     * @param actionName
     * @param id
     * @return
     */
    PmsAction getByActionNameNotEqId(String actionName, Long id);

    /**
     * 检查修改后的权限标识是否会与其他权限名冲突
     *
     * @param action
     * @param id
     * @return
     */
    PmsAction getByActionNotEqId(String action, Long id);

    /**
     * 根据菜单ID找出菜单下的所有权限
     *
     * @param menuId
     * @return
     */
    List<PmsAction> listAllByMenuId(Long menuId);

    /**
     * 根据菜单ID查找权限集
     *
     * @param menuId
     * @return
     */
    List<PmsAction> listByMenuId(Long menuId);
}
