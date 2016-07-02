package com.lhs.pay.core.user.dao;

import com.lhs.pay.facade.user.entity.PortalCa;

import java.util.List;

/**
 * IPortalCADao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IPortalCADao {

    /**
     *
     *
     * @param userNo
     * @param userId
     * @param userType
     * @return
     */
    List<PortalCa> listByUserIdAndtype(String userNo, Long userId, Integer userType);

    /**
     *
     * @param userNo
     * @return
     */
    List<PortalCa> listByUserNo(String userNo);
}
