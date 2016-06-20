package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMerchantRoleActionDao;
import com.lhs.pay.facade.user.entity.MerchantRoleAction;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * MerchantRoleActionDaoImpl
 *
 * @author longhuashen
 * @since 16/6/20
 */
@Repository("merchantRoleActionDao")
public class MerchantRoleActionDaoImpl extends BaseDaoImpl<MerchantRoleAction> implements IMerchantRoleActionDao {

    @Override
    public void deleteByActionId(long actionId) {
        super.getSqlSession().delete(getStatement("deleteByActionId"), actionId);
    }

    @Override
    public List<MerchantRoleAction> listMerchantRoleActionByRoleId(long roleId) {
        return super.getSqlSession().selectList(getStatement("selectListByRoleId"), roleId);
    }

    @Override
    public List<MerchantRoleAction> listByRoleIds(String roleIdStr) {
        List<String> roleIds = Arrays.asList(roleIdStr.split(","));
        return super.getSqlSession().selectList(getStatement("findRoleIds"), roleIdStr);
    }

    @Override
    public void saveRoleAction(Long roleId, String actionStr) {
        //先删除原有的关联关系
        MerchantRoleAction merchantRoleAction = new MerchantRoleAction();
        merchantRoleAction.setRoleId(roleId);
        List<MerchantRoleAction> merchantRoleActionList = this.listMerchantRoleActionByRoleId(roleId);
        Map<Long, MerchantRoleAction> delMap = new HashMap<>();

        for (MerchantRoleAction merchantRoleAction1 : merchantRoleActionList) {
            delMap.put(merchantRoleAction1.getActionId(), merchantRoleAction);
        }

        //创建新的关联
        String[] actionIds = actionStr.split(",");
        for (int i = 0; i < actionIds.length; i++) {
            long actionId = Long.parseLong(actionIds[i]);
            if (delMap.get(actionId) == null) {
                MerchantRoleAction merchantRoleActionNew = new MerchantRoleAction();
                merchantRoleActionNew.setActionId(actionId);
                merchantRoleActionNew.setRoleId(roleId);
                this.insert(merchantRoleActionNew);
            } else {
                delMap.remove(actionId);
            }
        }

        Iterator<Long> iterator = delMap.keySet().iterator();
        while (iterator.hasNext()) {
            long key = iterator.next();
            this.deleteByActionId(key);
        }
    }
}
