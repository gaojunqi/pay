package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMerchantRoleDao;
import com.lhs.pay.facade.user.entity.MerchantRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MerchantRoleDaoImpl
 *
 * @author longhuashen
 * @since 16/6/20
 */
@Repository("merchantRoleDao")
public class MerchantRoleDaoImpl extends BaseDaoImpl<MerchantRole> implements IMerchantRoleDao {

    @Override
    public MerchantRole findByUserNo(String userNo) {
        return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
    }

    @Override
    public List<MerchantRole> listAllRole() {
        return super.getSqlSession().selectList(getStatement("listAll"));
    }

    @Override
    public List<MerchantRole> listRoleByUserNo(String userNo) {
        return this.getSqlSession().selectList(getStatement("findRoleByUserNo"), userNo);
    }
}
