package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMerchantActionDao;
import com.lhs.pay.facade.user.entity.MerchantAction;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MerchantActionDaoImpl
 *
 * @author longhuashen
 * @since 16/6/15
 */
@Repository("merchantActionDao")
public class MerchantActionDaoImpl extends BaseDaoImpl<MerchantAction> implements IMerchantActionDao {

    @Override
    public List<MerchantAction> listByIds(String idsStr) {
        List<String> ids = Arrays.asList(idsStr.split(","));
        return this.getSqlSession().selectList(getStatement("findByIds"), ids);
    }

    @Override
    public List<MerchantAction> listMerActionByMerType(String merType) {
        Map<String, Object> params = new HashMap<>();
        return super.getSqlSession().selectList(getStatement("listMerActionByMerType"), params);
    }
}
