package com.lhs.pay.web.permission.biz.impl;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.web.permission.biz.IPmsRoleBiz;
import com.lhs.pay.web.permission.dao.IPmsRoleDao;
import com.lhs.pay.web.permission.dao.IPmsRoleOperatorDao;
import com.lhs.pay.web.permission.entity.PmsRole;
import com.lhs.pay.web.permission.entity.PmsRoleOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * PmsRoleBiz
 *
 * @author longhuashen
 * @since 16/4/11
 */
@Service("pmsRoleBiz")
public class PmsRoleBiz implements IPmsRoleBiz {

    @Autowired
    private IPmsRoleDao pmsRoleDao;

    @Autowired
    private IPmsRoleOperatorDao pmsRoleOperatorDao;

    @Override
    public List<PmsRole> listAll() {
        return pmsRoleDao.listAll();
    }

    @Override
    public void deleteById(Long id) {
        pmsRoleDao.deleteById(id);
    }

    @Override
    public PmsRole getRoleName(String roleName) {
        return pmsRoleDao.getRoleName(roleName);
    }

    @Override
    public PmsRole findByRoleNameNotEqId(Long id, String roleName) {
        return pmsRoleDao.findRoleNameNotEqId(id, roleName);
    }

    @Override
    public List<PmsRole> listByActionId(Long actionId) {
        return pmsRoleDao.listByActionId(actionId);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return pmsRoleDao.listPage(pageParam, paramMap);
    }

    @Override
    public PmsRole getById(Long id) {
        return pmsRoleDao.getById(id);
    }

    @Override
    public void create(PmsRole pmsRole) {
        pmsRoleDao.insert(pmsRole);
    }

    @Override
    public void update(PmsRole pmsRole) {
        pmsRoleDao.update(pmsRole);
    }

    @Override
    public void deleteRoleById(Long roleId) {
        //删除角色权限关联表中的数据

    }

    @Override
    public void updateRole(PmsRole pmsRole) {
        pmsRoleDao.update(pmsRole);
    }

    @Override
    public void saveRole(PmsRole pmsRole) {
        pmsRoleDao.insert(pmsRole);
    }

    @Override
    public String getRoleIdsByOperatorId(long operatorId) {
        //得到操作员和角色列表
        List<PmsRoleOperator> pmsRoleOperators = pmsRoleOperatorDao.listByOperatorId(operatorId);
        StringBuffer roleIdsBuf = new StringBuffer("");
        for (PmsRoleOperator rp : pmsRoleOperators) {
            roleIdsBuf.append(rp.getRoleId()).append(",");
        }
        String roleIds = roleIdsBuf.toString();
        if (StringUtils.isNotBlank(roleIds) && roleIds.length() > 0) {
            roleIds = roleIds.substring(0, roleIds.length() - 1);
        }
        return roleIds;
    }
}
