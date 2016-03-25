package com.lhs.pay.facade.user.service;

import com.lhs.pay.common.exceptions.BizException;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.user.entity.MemberInfo;
import com.lhs.pay.facade.user.exceptions.UserBizException;

import java.util.List;
import java.util.Map;

/**
 * MemberInfoFacade
 * 会员基本信息对外接口
 *
 * @author longhuashen
 * @since 16/3/21
 */
public interface MemberInfoFacade {

    /**
     * 根据用户编号（也就是会员编号）查询会员信息
     *
     * @param userNo 用户编号
     * @return
     * @throws UserBizException
     */
    MemberInfo getMemberByUserNo(String userNo) throws UserBizException;

    /**
     * 分页查询
     *
     * @param pageParam
     * @param paramMap
     * @return
     * @throws UserBizException
     */
    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws UserBizException;

    /**
     * 更新会员信息
     *
     * @param memberInfo
     * @return
     * @throws UserBizException
     */
    long update(MemberInfo memberInfo) throws UserBizException;

    /**
     * 根据id查询会员信息
     *
     * @param memberId
     * @return
     */
    MemberInfo getById(Long memberId) throws UserBizException;

    /**
     * 统计会员拉黑和冻结的人数
     *
     * @param listBlackUser
     * @param listFreezeUser
     * @return
     * @throws BizException
     */
    Map<String, Object> countMember(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser) throws BizException;
}
