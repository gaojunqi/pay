package com.lhs.pay.web.permission.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.web.permission.entity.PmsRole;

import java.util.List;

/**
 * IPmsRoleDao
 *
 * @author longhuashen
 * @since 16/4/11
 */
public interface IPmsRoleDao extends BaseDao<PmsRole> {

    /**
     * 列出所有角色
     *
     * @return
     */
    List<PmsRole> listAll();

    /**
     * 根据角色名称获取角色记录
     *
     * @param roleName
     * @return
     */
    PmsRole getRoleName(String roleName);

    /**
     * 查找是否存在与Id值不相同与角色名相同的角色记录
     *
     * @param id
     * @param roleName
     * @return
     */
    PmsRole findRoleNameNotEqId(Long id, String roleName);

    /**
     * 根据权限ID找出关联了此权限的角色
     *
     * @param actionId
     * @return
     */
    List<PmsRole> listByActionId(Long actionId);
}
