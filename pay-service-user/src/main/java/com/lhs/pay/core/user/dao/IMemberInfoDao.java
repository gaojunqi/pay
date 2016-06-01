package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.MemberInfo;

import java.util.List;
import java.util.Map;

/**
 * IMemberInfoDao
 * 会员信息表数据访问层接口
 *
 * @author longhuashen
 * @since 16/3/21
 */
public interface IMemberInfoDao extends BaseDao<MemberInfo> {

    /**
     * 根据身份证号码查询
     *
     * @param cardNo
     * @return
     */
    List findByCardNo(String cardNo);

    /**
     * 根据会员编号查询会员信息
     *
     * @param memberNo
     * @return
     */
    MemberInfo getMemberInfoByMemberNo(String memberNo);

    /**
     * 统计会员拉黑和冻结的人数
     *
     * @param listBlackUser
     * @param listFreezeUser
     * @return
     */
    Map<String, Object> countMember(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser);
}
