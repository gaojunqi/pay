package com.lhs.pay.web.permission.biz.impl;

import com.lhs.pay.web.permission.biz.IPmsMenuBiz;
import com.lhs.pay.web.permission.dao.IPmsMenuDao;
import com.lhs.pay.web.permission.entity.PmsMenu;
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

    }

    @Override
    public List listByRoleIds(String roleIdsStr) {
        return null;
    }

    @Override
    public void createMenu(PmsMenu pmsMenu) {

    }

    @Override
    public String getMenuIdsByRoleId(Long roleId) {
        return null;
    }

    @Override
    public String buildMenuActionTree(String menuIdStr, String actionIdsStr) {
        return null;
    }

    @Override
    public void buildPermissionTree(String pId, StringBuffer treeBuf, List allMenuList, String menuIds, String actionIds) {

    }

    @Override
    public void assignPermission(Long roleId, String menuIds, String actionIds) throws PermissionException {

    }

    @Override
    public String buildLookUpMenu() {
        return null;
    }

    @Override
    public List<PmsMenu> listByParentId(Long parentId) {
        return null;
    }

    @Override
    public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map) {
        return null;
    }

    @Override
    public PmsMenu getById(Long pid) {
        return null;
    }

    @Override
    public void update(PmsMenu pmsMenu) {

    }

    @Override
    public int countMenuByRoleId(Long roleId) {
        return 0;
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
