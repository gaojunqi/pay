package com.lhs.pay.web.permission.biz;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.web.permission.entity.PmsRole;

import java.util.List;
import java.util.Map;

/**
 * IPmsRoleBiz
 *
 * @author longhuashen
 * @since 16/4/11
 */
public interface IPmsRoleBiz {

    /**
     * 获取所有的角色列表
     *
     * @return
     */
    List<PmsRole> listAll();

    /**
     * 根据角色ID删除角色
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据角色名称获取角色记录(用于判断角色名是否已存在)
     *
     * @param roleName
     * @return
     */
    PmsRole getRoleName(String roleName);

    /**
     *
     * 查找是否存在与ID值不相同与角色名相同的角色记录
     *
     * @param id
     * @param roleName
     * @return
     */
    PmsRole findByRoleNameNotEqId(Long id, String roleName);

    /**
     * 根据权限ID找出了关联了此权限的角色
     *
     * @param actionId
     * @return
     */
    List<PmsRole> listByActionId(Long actionId);

    /**
     * 查询并分页列出角色信息
     *
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    /**
     * 根据ID获取角色
     *
     * @param id
     * @return
     */
    PmsRole getById(Long id);

    /**
     * 保存角色
     *
     * @param pmsRole
     */
    void create(PmsRole pmsRole);

    /**
     * 更新角色
     *
     * @param pmsRole
     */
    void update(PmsRole pmsRole);

    /**
     * 根据角色id删除角色，并删除与操作员、权限、菜单的关联关系
     *
     * @param roleId
     */
    void deleteRoleById(Long roleId);

    /**
     * 修改角色信息，并更新其关联的权限点
     *
     * @param pmsRole
     */
    void updateRole(PmsRole pmsRole);

    /**
     * 保存角色并关联权限
     *
     * @param pmsRole
     */
    void saveRole(PmsRole pmsRole);

    /**
     * 根据操作员id获得该操作员的所有角色id所拼成的String，每个ID用 ","分隔
     *
     * @param operatorId
     * @return
     */
    String getRoleIdsByOperatorId(long operatorId);
}
