package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMerchantRoleOperatorDao;
import com.lhs.pay.facade.user.entity.MerchantRoleOperator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * MerchantRoleOperatorDaoImpl
 *
 * @author longhuashen
 * @since 16/6/20
 */
@Repository("merchantRoleOperatorDao")
public class MerchantRoleOperatorDaoImpl extends BaseDaoImpl<MerchantRoleOperator> implements IMerchantRoleOperatorDao {

    @Override
    public void deleteByRoleId(Long roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
    }

    @Override
    public List<MerchantRoleOperator> listByOperatorId(long operatorId) {
        return super.getSqlSession().selectList(getStatement("selectListByOperatorId"), operatorId);
    }

    @Override
    public MerchantRoleOperator getByRoleIdAndOperatorId(Long roleId, Long operatorId) {
        MerchantRoleOperator merchantRoleOperator = new MerchantRoleOperator();
        merchantRoleOperator.setOperatorId(operatorId);
        merchantRoleOperator.setRoleId(roleId);
        return super.getSqlSession().selectOne(getStatement("getByRoleIdAndOperatorId"), merchantRoleOperator);
    }

    @Override
    public List listByRoleId(long roleId) {
        return super.getSqlSession().selectList(getStatement("getByRoleId"), roleId);
    }

    @Override
    public void saveRoleOperator(Long operatorId, String roleOpratorStr) {
        //删除原来的角色与操作员关联
        List<MerchantRoleOperator> merchantRoleOperatorList = this.listByOperatorId(operatorId);
        Map<Long, MerchantRoleOperator> delMap = new HashMap<>();
        for (MerchantRoleOperator merchantRoleOperator : merchantRoleOperatorList) {
            delMap.put(merchantRoleOperator.getRoleId(), merchantRoleOperator);
        }
        //创建新的关联
        String[] roleIds = roleOpratorStr.split(",");
        for (int i = 0; i < roleIds.length; i++) {
            long roleId = Long.parseLong(roleIds[i]);
            if (delMap.get(roleId) == null) {
                MerchantRoleOperator merchantRoleOperator = new MerchantRoleOperator();
                merchantRoleOperator.setOperatorId(operatorId);
                merchantRoleOperator.setRoleId(roleId);
                super.insert(merchantRoleOperator);
            } else {
                delMap.remove(roleId);
            }
        }
        Iterator<Long> iterator = delMap.keySet().iterator();
        while (iterator.hasNext()) {
            long key = iterator.next();
            this.deleteByRoleId(key);
        }
    }

    @Override
    public void saveRoleOperators(String roleIdStr, String operatorIdsStr) {
        String[] operatorIds = operatorIdsStr.split(",");
        String[] roleIds = roleIdStr.split(",");
        for (int i = 0; i < operatorIds.length; i++) {
            long operatorId = Long.parseLong(operatorIds[i]);
            for (int j = 0; j < roleIds.length; j++) {
                long roleId = Long.parseLong(roleIds[j]);
                MerchantRoleOperator merchantRoleOperator = this.getByRoleIdAndOperatorId(roleId, operatorId);
                if (merchantRoleOperator == null) {
                    MerchantRoleOperator merchantRoleOperatorNew = new MerchantRoleOperator();
                    merchantRoleOperatorNew.setOperatorId(operatorId);
                    merchantRoleOperatorNew.setRoleId(roleId);
                    super.insert(merchantRoleOperatorNew);
                }
            }
        }
    }
}
