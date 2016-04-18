package com.lhs.pay.web.permission.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.web.permission.dao.IPmsRoleOperatorDao;
import com.lhs.pay.web.permission.entity.PmsRoleOperator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PmsRoleOperatorDaoImpl
 *
 * @author longhuashen
 * @since 16/4/9
 */
@Repository("pmsRoleOperatorDao")
public class PmsRoleOperatorDaoImpl extends BaseDaoImpl<PmsRoleOperator> implements IPmsRoleOperatorDao {


    @Override
    public List<PmsRoleOperator> listByOperatorId(long operatorId) {
            return super.getSqlSession().selectList(getStatement("listByOperatorId"), operatorId);
    }

    @Override
    public List<PmsRoleOperator> listByRoleId(long roleId) {
        return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
    }

    @Override
    public void deleteByOperatorId(long operarotId) {
        super.getSqlSession().delete(getStatement("deleteByOperatorId"), operarotId);
    }

    @Override
    public void deleteByRoleId(long roleId) {
        super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
    }

    @Override
    public void deleteByRoleIdAndOperatorId(long roleId, long operatorId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("roleId", roleId);
        paramMap.put("operatorId", operatorId);
        super.getSqlSession().delete(getStatement("deleteByRoleIdAndOperatorId"), paramMap);
    }
}
