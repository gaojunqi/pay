package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.MerchantRole;

import java.util.List;

/**
 * IMerchantRoleDao
 *
 * @author longhuashen
 * @since 16/6/20
 */
public interface IMerchantRoleDao extends BaseDao<MerchantRole> {

    /**
     * 根据用户编号查询用户角色
     *
     * @param userNo
     * @return
     */
    MerchantRole findByUserNo(String userNo);

    /**
     * 列出所有角色
     *
     * @return
     */
    List<MerchantRole> listAllRole();

    /**
     * 根据用户编号查找商户角色
     *
     * @param userNo
     * @return
     */
    List<MerchantRole> listRoleByUserNo(String userNo);
}
