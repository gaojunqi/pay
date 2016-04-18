package com.lhs.pay.web.permission.biz.impl;

import com.lhs.pay.web.permission.biz.IPmsMenuBiz;
import com.lhs.pay.web.permission.dao.IPmsMenuDao;
import com.lhs.pay.web.permission.exception.PermissionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
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

        return null;
    }

    /**
     * 构建管理后台的树形权限功能菜单
     *
     * @param pId
     * @param treeBuf
     * @param menuList
     */
    private void buildAdminPermissionTree(String pId, StringBuffer treeBuf, List menuList) {
//        List<Map> listMap = getSonMenuByPid(pId.toString(), menuList);

    }
}
