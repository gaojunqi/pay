package com.lhs.pay.web.permission.biz;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.web.permission.entity.PmsOperator;
import com.lhs.pay.web.permission.entity.PmsRoleOperator;

import java.util.List;
import java.util.Map;

/**
 * IPmsOperatorBiz
 *
 * @author longhuashen
 * @since 16/4/9
 */
public interface IPmsOperatorBiz {

    /**
     * 根据登陆名取得操作员对象
     *
     * @param loginName
     * @return
     */
    PmsOperator findOperatorByLoginName(String loginName);

    /**
     * 根据id删除操作员
     *
     * @param operarotId
     */
    void deleteOperatorById(long operarotId);

    /**
     * 根据角色id查询用户
     *
     * @param roleId
     * @return
     */
    List<PmsOperator> listOperatorByRoleId(long roleId);

    /**
     * 更新操作员信息
     *
     * @param pmsOperator
     */
    void update(PmsOperator pmsOperator);

    /**
     * 根据操作员id更新操作员密码
     *
     * @param operatorId
     * @param newPwd
     * @param isTrue
     */
    void updateOperatorPwd(Long operatorId, String newPwd, boolean isTrue);

    /**
     * 根据id获取操作员信息
     *
     * @param operatorId
     * @return
     */
    PmsOperator getById(Long operatorId);

    /**
     * 查询分页并列出操作员信息
     *
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    /**
     * 保存操作员信息
     *
     * @param pmsOperator
     */
    void create(PmsOperator pmsOperator);

    /**
     *  保存操作员信息及其关联角色
     *
     * @param pmsOperator
     * @param roleOperatorStr
     */
    void saveOrUpdate(PmsOperator pmsOperator, String roleOperatorStr);

    /**
     * 修改操作员及其关联的角色信息
     *
     * @param pmsOperator
     * @param roleOperator
     */
    void updateOperator(PmsOperator pmsOperator, String roleOperator);

    /**
     * 根据角色id统计有多少个操作员关联到此角色
     *
     * @param roleId
     * @return
     */
    int countOperatorByRoleId(Long roleId);

    /**
     * 根据操作员id获得所有操作员-角色关联列表
     *
     * @param operatorId
     * @return
     */
    List<PmsRoleOperator> listRoleOperatorByOperatorId(long operatorId);
}
