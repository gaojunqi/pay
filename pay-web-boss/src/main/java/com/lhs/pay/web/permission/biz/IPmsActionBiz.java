package com.lhs.pay.web.permission.biz;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.web.permission.entity.PmsAction;

import java.util.List;
import java.util.Map;

/**
 * IPmsActionBiz
 *
 * 权限表--服务层接口
 *
 * @author longhuashen
 * @since 16/4/17
 */
public interface IPmsActionBiz {

    /**
     * 根据Action的id字符串得到相应的权限列表
     *
     * @param ids
     * @return
     */
    List<PmsAction> findActionsByIdStr(String ids);

    /**
     * 根据id删除权限信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据权限名称查找权限
     *
     * @param actionName
     * @return
     */
    PmsAction getByActionName(String actionName);

    /**
     * 根据action查找权限记录
     *
     * @param action
     * @return
     */
    PmsAction getAction(String action);

    /**
     * 检查修改后的权限名是否会与其他权限名冲突
     *
     * @param actionName
     * @param id
     * @return
     */
    PmsAction getByActionNameNotEqId(String actionName, Long id);

    /**
     * 根据菜单ID查找权限集
     *
     * @param menuId
     * @return
     */
    List<PmsAction> listByMenuId(Long menuId);

    /**
     * 分页列出权限功能点
     *
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    /**
     * 根据id获取权限
     *
     * @param id
     * @return
     */
    PmsAction getById(Long id);

    /**
     * 保存权限功能点
     *
     * @param pmsAction
     */
    void saveAction(PmsAction pmsAction);

    /**
     * 更新权限功能点
     *
     * @param pmsAction
     */
    void updateAction(PmsAction pmsAction);

    /**
     * 根据权限ID删除权限并解除权限与角色的关联关系
     *
     * @param actionId
     */
    void deleteByActionId(Long actionId);

    /**
     * 根据角色id统计有多少权限关联到此角色
     *
     * @param roleId
     * @return
     */
    int countActionByRoleId(Long roleId);

    /**
     * 根据角色ID，获取所有的功能权限ID集
     *
     * @param roleId
     * @return
     */
    String getActionIdsByRoleId(Long roleId);

    /**
     * 根据角色ID集得到所有权限ID集
     *
     * @param roleIds
     * @return
     */
    String getActionIdsByRoleIds(String roleIds);
}
