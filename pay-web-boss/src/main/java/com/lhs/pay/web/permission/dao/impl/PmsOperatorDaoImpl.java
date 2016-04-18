package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsOperatorDao;
import com.lhs.pay.web.permission.entity.PmsOperator;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PmsOperatorDaoImpl
 *
 * @author longhuashen
 * @since 16/4/9
 */
@Repository("pmsOperatorDao")
public class PmsOperatorDaoImpl extends BaseDaoImpl<PmsOperator> implements IPmsOperatorDao {

    @Override
    public PmsOperator findByLoginName(String loginName) {
        return super.getSqlSession().selectOne(getStatement("findByLoginName"), loginName);
    }

    @Override
    public List<PmsOperator> listByRoleId(long roleId) {
        return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
    }
}
