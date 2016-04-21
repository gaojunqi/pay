package com.lhs.pay.web.permission.biz;

import com.lhs.pay.web.permission.entity.PmsMenu;
import com.lhs.pay.web.permission.exception.PermissionException;

import java.util.List;
import java.util.Map;

/**
 * IPmsMenuBiz
 *
 * @author longhuashen
 * @since 16/4/12
 */
public interface IPmsMenuBiz {

    String getTreeMenu(String actionUrl);

    String buildPermissionTree(String roleIds) throws PermissionException;

    void delete(Long id);

    List listByRoleIds(String roleIdsStr);

    void createMenu(PmsMenu pmsMenu) throws PermissionException;

    String getMenuIdsByRoleId(Long roleId) throws PermissionException;

    /**
     * 根据已有的菜单ID集合、角色的功能点集合，生成菜单权限树
     *
     * @param menuIdStr
     * @param actionIdsStr
     * @return
     */
    String buildMenuActionTree(String menuIdStr, String actionIdsStr);

    /**
     * 创建分配权限的菜单树
     *
     * @param pId
     * @param treeBuf
     * @param allMenuList
     * @param menuIds
     * @param actionIds
     */
    void buildPermissionTree(String pId, StringBuffer treeBuf, List allMenuList, String menuIds, String actionIds);

    /**
     * 对角色分配权限
     *
     * @param roleId
     * @param menuIds
     * @param actionIds
     * @throws PermissionException
     */
    void assignPermission(Long roleId, String menuIds, String actionIds) throws PermissionException;

    String buildLookUpMenu();

    /**
     * 根据菜单ID查找菜单
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

    /**
     * 根据菜单ID获取菜单
     *
     * @param pid
     * @return
     */
    PmsMenu getById(Long pid);

    /**
     * 根据菜单ID获取菜单
     *
     * @param pmsMenu
     */
    void update(PmsMenu pmsMenu);

    /**
     * 根据角色ID统计关联到此角色的菜单数
     *
     * @param roleId
     * @return
     */
    int countMenuByRoleId(Long roleId);
}
