package com.lhs.pay.web.permission.biz.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.web.permission.biz.IPmsActionBiz;
import com.lhs.pay.web.permission.dao.IPmsActionDao;
import com.lhs.pay.web.permission.dao.IPmsRoleActionDao;
import com.lhs.pay.web.permission.entity.PmsAction;
import com.lhs.pay.web.permission.entity.PmsRoleAction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * PmsActionBizImpl
 *
 * @author longhuashen
 * @since 16/4/18
 */
@Service("pmsActionBiz")
public class PmsActionBizImpl implements IPmsActionBiz {

    @Autowired
    private IPmsActionDao pmsACtionDao;

    @Autowired
    private IPmsRoleActionDao pmsRoleActionDao;

    @Override
    public List<PmsAction> findActionsByIdStr(String ids) {
        return pmsACtionDao.findByIds(ids);
    }

    @Override
    public void delete(Long id) {
        pmsACtionDao.deleteById(id);
    }

    @Override
    public PmsAction getByActionName(String actionName) {
        return pmsACtionDao.getByActionName(actionName);
    }

    @Override
    public PmsAction getAction(String action) {
        return pmsACtionDao.getByAction(action);
    }

    @Override
    public PmsAction getByActionNameNotEqId(String actionName, Long id) {
        return pmsACtionDao.getByActionNameNotEqId(actionName, id);
    }

    @Override
    public List<PmsAction> listByMenuId(Long menuId) {
        return pmsACtionDao.listByMenuId(menuId);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return pmsACtionDao.listPage(pageParam, paramMap);
    }

    @Override
    public PmsAction getById(Long id) {
        return pmsACtionDao.getById(id);
    }

    @Override
    public void saveAction(PmsAction pmsAction) {
        pmsACtionDao.insert(pmsAction);
    }

    @Override
    public void updateAction(PmsAction pmsAction) {
        pmsACtionDao.update(pmsAction);
    }

    @Override
    public void deleteByActionId(Long actionId) {
        pmsACtionDao.deleteById(actionId);
        //删除权限和角色关联表中的关联关系
        pmsRoleActionDao.deleteByActionId(actionId);
    }

    @Override
    public int countActionByRoleId(Long roleId) {
        List<PmsRoleAction> actionList = pmsRoleActionDao.listByRoleId(roleId);
        if (actionList == null || actionList.isEmpty()) {
            return 0;
        } else {
            return actionList.size();
        }
    }

    @Override
    public String getActionIdsByRoleId(Long roleId) {
        List<PmsRoleAction> pmsRoleActions = pmsRoleActionDao.listByRoleId(roleId);
        StringBuffer actionIds = new StringBuffer();
        if (pmsRoleActions != null && !pmsRoleActions.isEmpty()) {
            for (PmsRoleAction rm : pmsRoleActions) {
                actionIds.append(rm.getActionId()).append(",");
            }
        }
        return actionIds.toString();
    }

    @Override
    public String getActionIdsByRoleIds(String roleIds) {
        // 得到角色－权限表中roleiId在ids中的所有关联对象
        List<PmsRoleAction> listPmsRoleActions = pmsRoleActionDao.listByRoleIds(roleIds);
        // 构建StringBuffer
        StringBuffer actionIdsBuf = new StringBuffer("");
        // 拼接字符串
        for (PmsRoleAction pmsRoleAction : listPmsRoleActions) {
            actionIdsBuf.append(pmsRoleAction.getActionId()).append(",");
        }
        String actionIds = actionIdsBuf.toString();
        // 截取字符串
        if (StringUtils.isNotBlank(actionIds) && actionIds.length() > 0) {
            actionIds = actionIds.substring(0, actionIds.length() - 1); // 去掉最后一个逗号
        }
        return actionIds;
    }
}