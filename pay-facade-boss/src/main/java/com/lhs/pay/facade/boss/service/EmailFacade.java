package com.lhs.pay.facade.boss.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.boss.entity.EmailVerify;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.List;
import java.util.Map;

/**
 * EmailFacade
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface EmailFacade {

    /**
     * 创建邮箱验证记录
     *
     * @param entity
     * @return
     * @throws BossBizException
     */
    long createEmailVerify(EmailVerify entity) throws BossBizException;

    /**
     * 更新邮箱验证记录
     *
     * @param entity
     * @return
     * @throws BossBizException
     */
    long updateEmailVerify(EmailVerify entity) throws BossBizException;

    /**
     * 批量修改状态
     *
     * @param paramMap
     * @return
     */
    long updateStatus(Map<String, Object> paramMap);

    /**
     * 根据id获取邮箱验证记录
     *
     * @param id
     * @return
     * @throws BossBizException
     */
    EmailVerify getEmailVerifyById(long id) throws BossBizException;

    /**
     * 根据令牌获取邮箱验证记录
     *
     * @param token
     * @return
     * @throws BossBizException
     */
    EmailVerify getEmailVerifyByToken(String token) throws BossBizException;

    /**
     * 分页查询邮箱验证记录
     *
     * @param pageParam
     * @param paramMap
     * @return
     * @throws BossBizException
     */
    PageBean queryEmailVerifyListPage(PageParam pageParam, Map<String, Object> paramMap) throws BossBizException;

    /**
     * 根据条件查询邮箱验证记录
     *
     * @param paramMap
     * @return
     * @throws BossBizException
     */
    List listModelByCondition(Map<String, Object> paramMap) throws BossBizException;
}
