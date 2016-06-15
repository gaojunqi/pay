package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMerchantFileDao;
import com.lhs.pay.facade.user.entity.MerchantFile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * MerchantFileDaoImpl
 *
 * @author longhuashen
 * @since 16/6/15
 */
@Repository("merchantFileDao")
public class MerchantFileDaoImpl extends BaseDaoImpl<MerchantFile> implements IMerchantFileDao {

    @Override
    public MerchantFile getByMerchantNo(String merchantNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("merchantNo", merchantNo);
        return super.getBy(paramMap);
    }
}
