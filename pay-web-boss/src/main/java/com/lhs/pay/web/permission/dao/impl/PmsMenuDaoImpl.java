package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsMenuDao;
import com.lhs.pay.web.permission.entity.PmsMenu;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * PmsMenuDaoImpl
 *
 * @author longhuashen
 * @since 16/4/12
 */
@Repository("pmsMenuDao")
public class PmsMenuDaoImpl extends BaseDaoImpl<PmsMenu> implements IPmsMenuDao{


    @Override
    public List listByRoleIds(String roleIdStr) {
        List<String> roleIds = Arrays.asList(roleIdStr.split(","));
        return super.getSqlSession().selectList(getStatement("listByRoleIds"), roleIds);
    }

    @Override
    public List listByParent(String parentId) {
        return super.getSqlSession().selectList(getStatement("listByParent"), parentId);
    }

    @Override
    public List<PmsMenu> listByParentId(Long parentId) {
        return super.getSqlSession().selectList(getStatement("listByParentId"), parentId);
    }

    @Override
    public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map) {
        return super.getSqlSession().selectList(getStatement("listBy"), map);
    }
}
