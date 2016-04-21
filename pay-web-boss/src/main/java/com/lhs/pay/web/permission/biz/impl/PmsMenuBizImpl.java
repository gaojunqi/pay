package com.lhs.pay.web.permission.biz.impl;

import com.lhs.pay.web.permission.biz.IPmsMenuBiz;
import com.lhs.pay.web.permission.dao.IPmsActionDao;
import com.lhs.pay.web.permission.dao.IPmsMenuDao;
import com.lhs.pay.web.permission.dao.IPmsRoleActionDao;
import com.lhs.pay.web.permission.dao.IPmsRoleMenuDao;
import com.lhs.pay.web.permission.entity.PmsAction;
import com.lhs.pay.web.permission.entity.PmsMenu;
import com.lhs.pay.web.permission.entity.PmsRoleAction;
import com.lhs.pay.web.permission.entity.PmsRoleMenu;
import com.lhs.pay.web.permission.exception.PermissionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * PmsMenuBizImpl
 *
 * @author longhuashen
 * @since 16/4/12
 */
@Service("pmsMenuBiz")
public class PmsMenuBizImpl implements IPmsMenuBiz {

    private static final Log log = LogFactory.getLog(PmsMenuBizImpl.class);

    @Autowired
    private IPmsMenuDao pmsMenuDao;

    @Autowired
    private IPmsRoleMenuDao pmsRoleMenuDao;

    @Autowired
    private IPmsActionDao pmsActionDao;

    @Autowired
    private IPmsRoleActionDao pmsRoleActionDao;

    @Override
    public String getTreeMenu(String actionUrl) {
        List treeData = getTreeData(null);
        StringBuffer strJson = new StringBuffer();
        recusionTreeMenu("0", strJson, treeData, actionUrl);
        return strJson.toString();
    }

    /**
     * 递归输出树形菜单
     *
     * @param s
     * @param strJson
     * @param treeData
     * @param actionUrl
     */
    private void recusionTreeMenu(String s, StringBuffer strJson, List treeData, String actionUrl) {

    }

    private List getTreeData(String parentId) {
        return pmsMenuDao.listByParent(parentId);
    }

    @Override
    public String buildPermissionTree(String roleIds) throws PermissionException {
        List treeData = null;
        try {
            treeData = pmsMenuDao.listByRoleIds(roleIds);
            if (treeData == null) {
                log.error("用户没有分配菜单权限");
            }
        } catch (Exception e) {
            log.error("根据角色查询菜单出现错误", e);
            throw new PermissionException(PermissionException.PERMISSION_QUERY_MENU_BY_ROLE_ERROR);
        }
        StringBuffer strJson = new StringBuffer();
        buildAdminPermissionTree("0", strJson, treeData);
        return strJson.toString();
    }

    @Override
    public void delete(Long id) {
        pmsMenuDao.deleteById(id);
    }

    @Override
    public List listByRoleIds(String roleIdsStr) {
        return pmsMenuDao.listByRoleIds(roleIdsStr);
    }

    @Override
    public void createMenu(PmsMenu pmsMenu) throws PermissionException {
        try {
            PmsMenu newPmsMenu = pmsMenu;
            PmsMenu parentPmsMenu = newPmsMenu.getParent();
            if (null == parentPmsMenu.getId()) {
                parentPmsMenu = new PmsMenu();
                parentPmsMenu.setId(0L);
                parentPmsMenu.setIsLeaf(true);
                parentPmsMenu.setLevel(1L);
                parentPmsMenu.setParent(parentPmsMenu);
            } else {
                parentPmsMenu = pmsMenuDao.getById(parentPmsMenu.getId());
                newPmsMenu.setIsLeaf(true);
                newPmsMenu.setLevel(parentPmsMenu.getLevel() + 1);
                parentPmsMenu.setIsLeaf(false);
                pmsMenuDao.update(parentPmsMenu);
            }
            pmsMenuDao.insert(newPmsMenu);
        } catch (Exception e) {
            log.error("添加菜单报错", e);
            throw new PermissionException("添加菜单SQL报错");
        }
    }

    @Override
    public String getMenuIdsByRoleId(Long roleId) throws PermissionException{
        List<PmsRoleMenu> menuList = pmsRoleMenuDao.listByRoleId(roleId);
        StringBuffer menuIds = new StringBuffer("");
        if (menuList != null && !menuList.isEmpty()) {
            for (PmsRoleMenu rm : menuList) {
                menuIds.append(rm.getMenuId()).append(",");
            }
        }
        return menuIds.toString();
    }

    @Override
    public String buildMenuActionTree(String menuIdStr, String actionIdsStr) {
        List allMenuList = getTreeData(null);
        StringBuffer treeBuf = new StringBuffer();
        buildPermissionTree("0", treeBuf, allMenuList, menuIdStr, actionIdsStr);
        return treeBuf.toString();
    }

    @Override
    public void buildPermissionTree(String pId, StringBuffer treeBuf, List allMenuList, String menuIds, String actionIds) {
        if (pId.equals("0")) {
            treeBuf.append("<ul class=\"tree treeFolder treeCheck expand\" >");
        } else {
            treeBuf.append("<ul>");
        }

        List<Map> sonMenuList = getSonMenuListByPid(pId.toString(), allMenuList);
        for (Map sonMenu : sonMenuList) {
            String menuId = sonMenu.get("id").toString();// id
            String parentId = sonMenu.get("pId").toString(); // PID
            String name = sonMenu.get("name").toString();// 名称
            String isLeaf = sonMenu.get("isLeaf").toString();// 是否叶子
            if (menuIds.indexOf("," + menuId + ",") > -1) {
                treeBuf.append("<li><a menuid='" + menuId + "' checked='true' pid='" + parentId + "' isleaf='" + isLeaf + "'>" + name + " (M)</a>");
            } else {
                treeBuf.append("<li><a menuid='" + menuId + "' pid='" + parentId + "' isleaf='" + isLeaf + "'>" + name + " (M)</a>");
            }
            if (isLeaf.equals("1")) {
                // 如果叶子菜单，则处理挂在此菜单下的权限功能点

                // 获取叶子菜单下所有的功能权限
                List<PmsAction> actionList = pmsActionDao.listAllByMenuId(Long.valueOf(menuId));
                if (null != actionList && !actionList.isEmpty()) {
                    treeBuf.append("<ul>");
                    for (int j = 0; j < actionList.size(); j++) {
                        PmsAction action = actionList.get(j);
                        if (actionIds.indexOf("," + action.getId().toString() + ",") > -1) {
                            treeBuf.append("<li><a checked='true' actionid='" + action.getId() + "'>" + action.getActionName() + " (A)</a>");
                        } else {
                            treeBuf.append("<li><a actionid='" + action.getId() + "'>" + action.getActionName() + " (A)</a>");
                        }
                    }
                    treeBuf.append("</ul>");
                }

            } else {
                // 不是叶子菜单，递归
                buildPermissionTree(menuId, treeBuf, allMenuList, menuIds, actionIds);
            }
            treeBuf.append("</li>");
        }

        treeBuf.append("</ul>");
    }

    private List<Map> getSonMenuListByPid(String pId, List menuList) {
        List sonMenuList = new ArrayList<Object>();
        for (Object menu : menuList) {
            Map map = (Map) menu;
            if (map != null) {
                String parentId = map.get("pId").toString();// 父id
                if (parentId.equals(pId)) {
                    sonMenuList.add(map);
                }
            }
        }
        return sonMenuList;
    }

    @Override
    public void assignPermission(Long roleId, String menuIds, String actionIds) throws PermissionException {
        if (roleId != null) {
            throw new PermissionException(PermissionException.PERMISSION_ASSIGN_MENU_ROLE_NULL); // 角色ID为空
        }

        // 先删除所有的菜单权限
        pmsRoleMenuDao.deleteByRoleId(roleId);

        List<String> oldMenuIdList = new ArrayList<String>();
        // 删除功能权限
        pmsRoleActionDao.deleteByRoleId(roleId);
        if (StringUtils.isNotEmpty(menuIds)) {
            String[] menuArray = menuIds.split(",");
            for (String menuId : menuArray) {
                if(!oldMenuIdList.contains(menuId)){
                    // 防止重复添加菜单权限
                    PmsRoleMenu entity = new PmsRoleMenu();
                    entity.setRoleId(roleId);
                    entity.setMenuId(Long.valueOf(menuId));
                    // 新增菜单权限
                    pmsRoleMenuDao.insert(entity);
                }
                oldMenuIdList.add(menuId);
            }
        }

        if (StringUtils.isNotEmpty(actionIds)) {
            String[] actionArray = actionIds.split(",");
            for (String actionId : actionArray) {
                PmsRoleAction entity = new PmsRoleAction();
                entity.setRoleId(roleId);
                entity.setActionId(Long.valueOf(actionId));
                // 新增功能权限
                pmsRoleActionDao.insert(entity);
            }
        }
    }

    @Override
    public String buildLookUpMenu() {
        List treeData = getTreeData(null);
        StringBuffer strJson = new StringBuffer();
        recursionTreeMenuLookUp("0", strJson, treeData);
        return strJson.toString();
    }

    private void recursionTreeMenuLookUp(String pId, StringBuffer buffer, List list) {
        if ("0".equals(pId)) {
            buffer.append("<ul class=\"tree treeFolder\" >");
        } else {
            buffer.append("<ul>");
        }
        List<Map> listMap = getSonMenuListByPid(pId, list);
        for (Map map : listMap) {
            String id = map.get("id").toString();// id
            String parentId = map.get("pId").toString();// 父id
            String name = map.get("name").toString();// 名称
            String isLeaf = map.get("isLeaf").toString();// 是否叶子科目

            if (isLeaf.equals("1")) {
                buffer.append("<li><a onclick=\"$.bringBack({id:'" + id + "', name:'" + name + "'})\"  href=\"javascript:\"  >" + name + "</a>");
            } else {
                buffer.append("<li><a id='" + id + "' pid='" + parentId + "' isleaf='" + isLeaf + "'>" + name + "</a>");
            }

            if (!isLeaf.equals("1")) {
                recursionTreeMenuLookUp(id, buffer, list);
            }
            buffer.append("</li>");
        }
        buffer.append("</ul>");
    }

    @Override
    public List<PmsMenu> listByParentId(Long parentId) {
        return pmsMenuDao.listByParentId(parentId);
    }

    @Override
    public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map) {
        return null;
    }

    @Override
    public PmsMenu getById(Long pid) {
        return pmsMenuDao.getById(pid);
    }

    @Override
    public void update(PmsMenu pmsMenu) {
        pmsMenuDao.update(pmsMenu);
    }

    @Override
    public int countMenuByRoleId(Long roleId) {
        List<PmsRoleMenu> menuList = pmsRoleMenuDao.listByRoleId(roleId);
        if (menuList == null || menuList.isEmpty()) {
            return 0;
        } else {
            return menuList.size();
        }
    }

    /**
     * 构建管理后台的树形权限功能菜单
     *
     * @param pId
     * @param treeBuf
     * @param menuList
     */
    private void buildAdminPermissionTree(String pId, StringBuffer treeBuf, List menuList) {
        List<Map> listMap = getSonMenuByPid(pId.toString(), menuList);
        for (Map map : listMap) {
            String id = map.get("id").toString();
            String name = map.get("name").toString();
            String isLeaf = map.get("isLeaf").toString();
            String level = map.get("level").toString();
            String url = map.get("url").toString();
            String navTabId = "";
            if (null != map.get("targetName")) {
                navTabId = map.get("targetName").toString();
            }

            if ("1".equals(level)) {
                treeBuf.append("<div class='accordionHeader'>");
                treeBuf.append("<h2>" + name + "</h2>");
                treeBuf.append("</div>");
                treeBuf.append("<div class='accordionContent'>");
            }

            if ("1".equals(isLeaf)) {
                treeBuf.append("<li><a href='" + url + "' target='navTab' rel='" + navTabId + "'>" + name + "</a></li>");
            } else {

                if ("1".equals(level)){
                    treeBuf.append("<ul class='tree treeFolder'>");
                }else{
                    treeBuf.append("<li><a>" + name + "</a>");
                    treeBuf.append("<ul>");
                }

                buildAdminPermissionTree(id, treeBuf, menuList);

                if ("1".equals(level)){
                    treeBuf.append("</ul>");
                }else{
                    treeBuf.append("</ul></li>");
                }

            }

            if ("1".equals(level)){
                treeBuf.append("</div>");
            }
        }
    }

    /**
     * 根据pId获取menuList中的所有的子菜单集合
     *
     * @param pId
     * @param menuList
     * @return
     */
    private List<Map> getSonMenuByPid(String pId, List menuList) {
        List sonMenuList = new ArrayList();
        for (Object menu : menuList) {
            Map map = (Map) menu;
            if (map != null) {
                String parentId = map.get("pId").toString();
                if (parentId.equals(pId)) {
                      sonMenuList.add(map);
                }
            }
        }
        return sonMenuList;
    }
}
