package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMemberInfoDao;
import com.lhs.pay.facade.user.entity.MemberInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IMemberInfoDaoImpl
 *
 * 会员信息表数据访问层接口实现类
 *
 * @author longhuashen
 * @since 16/3/28
 */
@Repository("memberInfoDao")
public class IMemberInfoDaoImpl extends BaseDaoImpl<MemberInfo> implements IMemberInfoDao {

    @Override
    public List findByCardNo(String cardNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("cardNo", cardNo);
        return super.listBy(map);
    }

    @Override
    public MemberInfo getMemberInfoByMemberNo(String memberNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("memberNo", memberNo);
        return super.getBy(map);
    }

    @Override
    public Map<String, Object> countMember(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser) {
        List<String> blackList = new ArrayList<>();
        for (Map<String, Object> map : listBlackUser) {
            blackList.add(map.get("USERNO").toString());
        }

        List<String> freezeList = new ArrayList<>();
        for (Map<String, Object> map : listFreezeUser) {
            freezeList.add(map.get("USERNO").toString());
        }

        Map<String, Object> map = new HashMap<>();
        if (freezeList.size() == 0) {
            map.put("sumFreeze", "0");
        } else {
            map.put("sumFreeze", super.getSqlSession().selectOne(getStatement("sumFreeze"), freezeList));
        }

        if (freezeList.size() == 0) {
            map.put("sumBlack", "0");
        } else {
            map.put("sumBlack", super.getSqlSession().selectOne(getStatement("sumBlack"), blackList));
        }
        return map;
    }
}
