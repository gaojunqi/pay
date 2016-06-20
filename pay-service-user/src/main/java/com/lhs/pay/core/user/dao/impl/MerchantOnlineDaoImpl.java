package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.core.user.dao.IMerchantOnlineDao;
import com.lhs.pay.facade.user.entity.MerchantOnline;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MerchantOnlineDaoImpl
 *
 * @author longhuashen
 * @since 16/6/20
 */
@Repository("merchantOnlineDao")
public class MerchantOnlineDaoImpl extends BaseDaoImpl<MerchantOnline> implements IMerchantOnlineDao {

    @Override
    public MerchantOnline getByMerchantNo(String merchantNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("merchantNo", merchantNo);
        return super.getBy(map);
    }

    @Override
    public MerchantOnline getByCardNo(String cardNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("cardNo", cardNo);
        return super.getBy(map);
    }

    @Override
    public MerchantOnline getByFullName(String fullName) {
        Map<String, Object> map = new HashMap<>();
        map.put("fullName", fullName);
        return super.getBy(map);
    }

    @Override
    public MerchantOnline getByLicenseNo(String licenseNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("licenseNo", licenseNo);
        return super.getBy(map);
    }

    @Override
    public Map<String, Object> countMerchant(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser) {
        List<String> blackList = new ArrayList<>();
        for (Map<String, Object> map : listBlackUser) {
            blackList.add(map.get("USERNO").toString());
        }

        List<String> freezeList = new ArrayList<>();
        for (Map<String, Object> map : listFreezeUser) {
            freezeList.add(map.get("USERNO").toString());
        }

        Map<String, Object> map = new HashMap<>();
        if (freezeList.size() == 0) {
            map.put("sumFreezeList", freezeList);
        } else {
            map.put("sumFreezeList",
                    super.getSqlSession().selectList(getStatement("sumFreezeList"),
                            freezeList));
        }
        if (blackList.size() == 0) {
            map.put("sumBlackList", blackList);
        } else {
            map.put("sumBlackList",
                    super.getSqlSession().selectList(getStatement("sumBlackList"),
                            blackList));
        }

        return map;
    }

    @Override
    public PageBean agentMerchantStatusSumm(PageParam pageParam, Map<String, Object> paramMap) {
        return super.listPage(pageParam, paramMap, "agentMerchantStatusSumm");
    }
}
