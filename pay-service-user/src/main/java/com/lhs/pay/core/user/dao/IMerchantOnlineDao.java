package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.user.entity.MerchantOnline;

import java.util.List;
import java.util.Map;

/**
 * IMerchantOnlineDao
 *
 * 在线支付的商户信息表数据访问层接口
 *
 * @author longhuashen
 * @since 16/6/19
 */
public interface IMerchantOnlineDao extends BaseDao<MerchantOnline> {

    /**
     * 根据商户编号获取在线支付商户信息
     *
     * @param merchantNo
     * @return
     */
    MerchantOnline getByMerchantNo(String merchantNo);

    /**
     * 根据身份证号获取在线支付商户信息
     *
     * @param cardNo
     * @return
     */
    MerchantOnline getByCardNo(String cardNo);

    /**
     * 根据商户全称获取在线支付商户信息
     *
     * @param fullName
     * @return
     */
    MerchantOnline getByFullName(String fullName);

    /**
     * 根据营业执照号获取在线支付商户信息
     *
     * @param licenseNo
     * @return
     */
    MerchantOnline getByLicenseNo(String licenseNo);

    /**
     * 查询黑名单和冻结商户的数量
     *
     * @param listBlackUser
     * @param listFreezeUser
     * @return
     */
    Map<String, Object> countMerchant(List<Map<String, Object>> listBlackUser, List<Map<String, Object>> listFreezeUser);

    /**
     * 代理商户状态统计报表
     *
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean agentMerchantStatusSumm(PageParam pageParam, Map<String, Object> paramMap);
}
