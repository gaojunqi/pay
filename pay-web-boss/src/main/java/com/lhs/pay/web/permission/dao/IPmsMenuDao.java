package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsMenu;

import java.util.List;

/**
 * IPmsMenuDao
 *
 * @author longhuashen
 * @since 16/4/12
 */
public interface IPmsMenuDao extends BaseDao<PmsMenu> {

    /**
     * 根据角色id查找菜单列表
     *
     * @param roleIdStr
     * @return
     */
    List listByRoleIds(String roleIdStr);
}
