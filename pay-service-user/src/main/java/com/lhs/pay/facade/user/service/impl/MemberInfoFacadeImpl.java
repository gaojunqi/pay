package com.lhs.pay.facade.user.service.impl;

import com.lhs.pay.common.exceptions.BizException;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.user.entity.MemberInfo;
import com.lhs.pay.facade.user.exceptions.UserBizException;
import com.lhs.pay.facade.user.service.MemberInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * MemberInfoFacadeImpl
 * 用户对外提供接口实现
 *
 * @author longhuashen
 * @since 16/3/21
 */
@Service("memberIinfoFacade")
public class MemberInfoFacadeImpl implements MemberInfoFacade {

    @Autowired
    //private MemberInfoDao memberInfoDao;

    @Override
    public MemberInfo getMemberByUserNo(String userNo) throws UserBizException {
        return null;
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws UserBizException {
        return null;
    }

    @Override
    public long update(MemberInfo memberInfo) throws UserBizException {
        return 0;
    }

    @Override
    public MemberInfo getById(Long memberId) throws UserBizException {
        return null;
    }

    @Override
    public Map<String, Object> countMember(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser) throws BizException {
        return null;
    }
}
