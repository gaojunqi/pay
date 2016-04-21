package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsMenu;

import java.util.List;
import java.util.Map;

/**
 * IPmsMenuDao
 *
 * @author longhuashen
 * @since 16/4/12
 */
public interface IPmsMenuDao extends BaseDao<PmsMenu> {

    /**
     * 根据角色id查找菜单列表
     *
     * @param roleIdStr
     * @return
     */
    List listByRoleIds(String roleIdStr);

    /**
     * 根据菜单ID获取该菜单下的所有子孙菜单
     *
     * @param parentId
     * @return
     */
    List listByParent(String parentId);

    /**
     * 根据父菜单ID获取该菜单下的所有子孙菜单
     *
     * @param parentId
     * @return
     */
    List<PmsMenu> listByParentId(Long parentId);

    /**
     * 根据名称和是否叶子节点查询数据
     *
     * @param map
     * @return
     */
    List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map);


}
