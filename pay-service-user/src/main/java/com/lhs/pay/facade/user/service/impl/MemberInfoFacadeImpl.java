package com.lhs.pay.facade.user.service.impl;

import com.lhs.pay.common.exceptions.BizException;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.core.user.dao.IMemberInfoDao;
import com.lhs.pay.facade.user.entity.MemberInfo;
import com.lhs.pay.facade.user.exceptions.UserBizException;
import com.lhs.pay.facade.user.service.MemberInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * MemberInfoFacadeImpl
 *
 * 用户对外提供接口实现
 *
 * @author longhuashen
 * @since 16/3/21
 */
@Service("memberInfoFacade")
public class MemberInfoFacadeImpl implements MemberInfoFacade {

    @Autowired
    private IMemberInfoDao IMemberInfoDao;

    @Override
    public MemberInfo getMemberByUserNo(String userNo) throws UserBizException {
        return IMemberInfoDao.getMemberInfoByMemberNo(userNo);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws UserBizException {
        return IMemberInfoDao.listPage(pageParam, paramMap);
    }

    @Override
    public long update(MemberInfo memberInfo) throws UserBizException {
        return IMemberInfoDao.update(memberInfo);
    }

    @Override
    public MemberInfo getById(Long memberId) throws UserBizException {
        return IMemberInfoDao.getById(memberId);
    }

    @Override
    public Map<String, Object> countMember(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser) throws BizException {
        return IMemberInfoDao.countMember(listBlackUser, listFreezeUser);
    }
}
