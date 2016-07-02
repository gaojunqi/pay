package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IMerchantSecretDao;
import com.lhs.pay.facade.user.entity.MerchantSecret;
import org.springframework.stereotype.Repository;

/**
 * MerchantSecretDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("merchantSecretDao")
public class MerchantSecretDaoImpl extends BaseDaoImpl<MerchantSecret> implements IMerchantSecretDao {
}
