package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.MerchantAction;

import java.util.List;

/**
 * IMerchantActionDao
 *
 * 商户权限管理--权限功能点表数据访问层接口
 *
 * @author longhuashen
 * @since 16/6/15
 */
public interface IMerchantActionDao extends BaseDao<MerchantAction> {

    /**
     * 根据实体ID字符串获取对象列表
     *
     * @param ids
     * @return
     */
    List<MerchantAction> listByIds(String ids);

    List<MerchantAction> listMerActionByMerType(String merType);

}
