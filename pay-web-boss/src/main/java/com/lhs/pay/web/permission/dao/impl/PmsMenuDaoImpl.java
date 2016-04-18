package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsMenuDao;
import com.lhs.pay.web.permission.entity.PmsMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return null;
    }
}
