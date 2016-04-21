package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsRoleActionDao;
import com.lhs.pay.web.permission.entity.PmsRole;
import com.lhs.pay.web.permission.entity.PmsRoleAction;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * PmsRoleActionDaoImpl
 *
 * @author longhuashen
 * @since 16/4/18
 */
@Repository("pmsRoleActionDao")
public class PmsRoleActionDaoImpl extends BaseDaoImpl<PmsRoleAction> implements IPmsRoleActionDao {


    @Override
    public List<PmsRoleAction> listByRoleId(Long roleId) {
        return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
    }

    @Override
    public List<PmsRoleAction> listByRoleIds(String roleIdsStr) {
        List<String> roleIds = Arrays.asList(roleIdsStr.split(","));
        return super.getSqlSession().selectList(getStatement("listByRoleIds"), roleIds);
    }

    @Override
    public List<PmsRoleAction> listByActionId(Long actionId) {
        return super.getSqlSession().selectList(getStatement("listByActionId"), actionId);
    }

    @Override
    public void deleteByActionId(Long actionId) {
        super.getSqlSession().delete(getStatement("deleteByActionId"), actionId);
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
    }
}
