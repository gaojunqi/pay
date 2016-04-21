package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsRoleMenuDao;
import com.lhs.pay.web.permission.entity.PmsRoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PmsRoleMenuDao
 *
 * @author longhuashen
 * @since 16/4/20
 */
@Repository("pmsRoleMenuDao")
public class PmsRoleMenuDao extends BaseDaoImpl<PmsRoleMenu> implements IPmsRoleMenuDao {


    @Override
    public void deleteByRoleId(Long roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
    }

    @Override
    public List<PmsRoleMenu> listByRoleId(Long roleId) {
        return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
    }
}
