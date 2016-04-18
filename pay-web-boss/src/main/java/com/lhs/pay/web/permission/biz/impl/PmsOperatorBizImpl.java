package com.lhs.pay.web.permission.biz.impl;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.web.permission.biz.IPmsOperatorBiz;
import com.lhs.pay.web.permission.dao.IPmsOperatorDao;
import com.lhs.pay.web.permission.dao.IPmsRoleOperatorDao;
import com.lhs.pay.web.permission.entity.PmsOperator;
import com.lhs.pay.web.permission.entity.PmsRoleOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * PmsOperatorBizImpl
 *
 * @author longhuashen
 * @since 16/4/9
 */
@Service("pmsOperatorBiz")
public class PmsOperatorBizImpl implements IPmsOperatorBiz {

    @Autowired
    private IPmsOperatorDao pmsOperatorDao;

    @Autowired
    private IPmsRoleOperatorDao pmsRoleOperatorDao;

    @Override
    public PmsOperator findOperatorByLoginName(String loginName) {
        return pmsOperatorDao.findByLoginName(loginName);
    }

    @Override
    public void deleteOperatorById(long operarotId) {
        PmsOperator pmsOperator = pmsOperatorDao.getById(operarotId);
        if (pmsOperator != null) {
            if ("1".equals(pmsOperator.getType())) {
                throw new RuntimeException("【" + pmsOperator.getLoginName() +"】为超级管理员，不能删除！");
            }
            pmsOperatorDao.deleteById(operarotId);
            //删除原来的角色与操作员关联
            pmsRoleOperatorDao.deleteByOperatorId(operarotId);
        }
    }

    @Override
    public List<PmsOperator> listOperatorByRoleId(long roleId) {
        return pmsOperatorDao.listByRoleId(roleId);
    }

    @Override
    public void update(PmsOperator pmsOperator) {
        pmsOperatorDao.update(pmsOperator);
    }

    @Override
    public void updateOperatorPwd(Long operatorId, String newPwd, boolean isTrue) {
        PmsOperator pmsOperator = pmsOperatorDao.getById(operatorId);
        pmsOperator.setLoginPwd(newPwd);
        pmsOperator.setPwdErrorCount(0);
        pmsOperator.setIsChangedPwd(isTrue);
        pmsOperatorDao.update(pmsOperator);
    }

    @Override
    public PmsOperator getById(Long operatorId) {
        return pmsOperatorDao.getById(operatorId);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return pmsOperatorDao.listPage(pageParam, paramMap);
    }

    @Override
    public void create(PmsOperator pmsOperator) {
        pmsOperatorDao.insert(pmsOperator);
    }

    @Override
    public void saveOrUpdate(PmsOperator pmsOperator, String roleOperatorStr) {
        //保存操作员信息
        pmsOperatorDao.insert(pmsOperator);
        //保存角色关联信息
        if (StringUtils.isNotBlank(roleOperatorStr) && roleOperatorStr.length() > 0) {
            saveOrUpdateRoleOperator(pmsOperator.getId(), roleOperatorStr);
        }
    }

    /**
     * 保存用户和角色之间的关联关系
     *
     * @param operatorId
     * @param roleOperatorStr
     */
    private void saveOrUpdateRoleOperator(Long operatorId, String roleOperatorStr) {
        //删除原来的角色与操作员关联
        List<PmsRoleOperator> pmsRoleOperators = pmsRoleOperatorDao.listByOperatorId(operatorId);
        Map<Long, PmsRoleOperator> delMap = new HashMap<>();
        for (PmsRoleOperator pmsRoleOperator : pmsRoleOperators) {
            delMap.put(pmsRoleOperator.getId(), pmsRoleOperator);
        }

        if(StringUtils.isNotBlank(roleOperatorStr)) {
            //创建新的关联
            String[] roleIds = roleOperatorStr.split(",");
            for (int i = 0; i < roleIds.length; i++) {
                long roleId = Long.parseLong(roleIds[i]);
                if (delMap.get(roleId) == null) {
                    PmsRoleOperator pmsRoleOperator = new PmsRoleOperator();
                    pmsRoleOperator.setOperatorId(operatorId);
                    pmsRoleOperator.setRoleId(roleId);
                    pmsRoleOperatorDao.insert(pmsRoleOperator);
                } else {
                    delMap.remove(roleId);
                }
            }
        }

        Iterator<Long> iterator = delMap.keySet().iterator();
        while (iterator.hasNext()) {
            long roleId = iterator.next();
            pmsRoleOperatorDao.deleteByRoleIdAndOperatorId(roleId, operatorId);
        }
    }

    @Override
    public void updateOperator(PmsOperator pmsOperator, String roleOperatorStr) {
        pmsOperatorDao.update(pmsOperator);
        saveOrUpdateRoleOperator(pmsOperator.getId(), roleOperatorStr);
    }

    @Override
    public int countOperatorByRoleId(Long roleId) {
        List<PmsRoleOperator> pmsRoleOperatorList = pmsRoleOperatorDao.listByRoleId(roleId);
        if (pmsRoleOperatorList == null || pmsRoleOperatorList.isEmpty()) {
            return 0;
        } else {
            return pmsRoleOperatorList.size();
        }
    }

    @Override
    public List<PmsRoleOperator> listRoleOperatorByOperatorId(long operatorId) {
        return pmsRoleOperatorDao.listByOperatorId(operatorId);
    }
}
