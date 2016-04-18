package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsActionDao;
import com.lhs.pay.web.permission.entity.PmsAction;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PmsActionDaoImpl
 *
 * @author longhuashen
 * @since 16/4/18
 */
@Repository("pmsActionDao")
public class PmsActionDaoImpl extends BaseDaoImpl<PmsAction> implements IPmsActionDao {

    @Override
    public List<PmsAction> findByIds(String idStr) {
        List<String> ids = Arrays.asList(idStr.split(","));
        return this.getSqlSession().selectList(getStatement("findByIds"), ids);
    }

    @Override
    public PmsAction getByActionName(String actionName) {
        return this.getSqlSession().selectOne(getStatement("getByActionName"), actionName);
    }

    @Override
    public PmsAction getByAction(String action) {
        return this.getSqlSession().selectOne(getStatement("getByAction"), action);
    }

    @Override
    public PmsAction getByActionNameNotEqId(String actionName, Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("actionName", actionName);
        param.put("id", id);
        return this.getSqlSession().selectOne(getStatement("getByActionNameNotEqId"), id);
    }

    @Override
    public PmsAction getByActionNotEqId(String action, Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("action", action);
        param.put("id", id);
        return this.getSqlSession().selectOne(getStatement("getByActionNotEqId"), id);
    }

    @Override
    public List<PmsAction> listAllByMenuId(Long menuId) {
        Map<String, Object> param = new HashMap<>();
        param.put("menuId", menuId);
        return this.getSqlSession().selectList(getStatement("listAllByMenuId"), param);
    }

    @Override
    public List<PmsAction> listByMenuId(Long menuId) {
        return this.getSqlSession().selectList(getStatement("listByMenuId"), menuId);
    }
}
