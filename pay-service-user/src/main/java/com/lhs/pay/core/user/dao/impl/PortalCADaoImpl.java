package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IPortalCADao;
import com.lhs.pay.facade.user.entity.PortalCa;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PortalCADaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("portalCADao")
public class PortalCADaoImpl extends BaseDaoImpl<PortalCa> implements IPortalCADao {

    @Override
    public List<PortalCa> listByUserIdAndtype(String userNo, Long userId, Integer userType) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("userId", userId);
        map.put("userType", userType);
        return super.listBy(map);
    }

    @Override
    public List<PortalCa> listByUserNo(String userNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        return super.listBy(map);
    }
}
