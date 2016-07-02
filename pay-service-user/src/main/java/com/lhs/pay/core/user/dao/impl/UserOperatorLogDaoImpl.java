package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.core.user.dao.IUserOperatorLogDao;
import com.lhs.pay.facade.user.entity.UserOperatorLog;
import org.springframework.stereotype.Repository;

/**
 * UserOperatorLogDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("userOperatorLogDao")
public class UserOperatorLogDaoImpl extends BaseDaoImpl<UserOperatorLog> implements IUserOperatorLogDao {
}
