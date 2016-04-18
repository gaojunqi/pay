package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsRoleDao;
import com.lhs.pay.web.permission.entity.PmsRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PmsRoleDaoImpl
 *
 * @author longhuashen
 * @since 16/4/11
 */
@Repository("pmsRoleDao")
public class PmsRoleDaoImpl extends BaseDaoImpl<PmsRole> implements IPmsRoleDao {

    @Override
    public List<PmsRole> listAll() {
        return super.getSqlSession().selectList(getStatement("listAll"));
    }

    @Override
    public PmsRole getRoleName(String roleName) {
        return super.getSqlSession().selectOne(getStatement("getRoleName"), roleName);
    }

    @Override
    public PmsRole findRoleNameNotEqId(Long id, String roleName) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("roleName", roleName);
        return super.getSqlSession().selectOne(getStatement("findRoleNameNotEqId"), param);
    }

    @Override
    public List<PmsRole> listByActionId(Long actionId) {
        return super.getSqlSession().selectList(getStatement("listByActionId"), actionId);
    }
}
