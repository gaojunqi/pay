package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.MerchantFile;

/**
 * IMerchantFileDao
 *
 * @author longhuashen
 * @since 16/6/15
 */
public interface IMerchantFileDao extends BaseDao<MerchantFile> {

    /**
     * 根据商户编号查询资质文件信息
     *
     * @param merchantNo
     * @return
     */
    MerchantFile getByMerchantNo(String merchantNo);
}
