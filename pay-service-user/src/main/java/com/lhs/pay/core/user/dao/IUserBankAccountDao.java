package com.lhs.pay.core.user.dao;

import com.lhs.pay.common.core.dao.BaseDao;
import com.lhs.pay.facade.user.entity.UserBankAccount;

import java.util.List;

/**
 * IUserBankAccountDao
 *
 * @author longhuashen
 * @since 16/7/2
 */
public interface IUserBankAccountDao extends BaseDao<UserBankAccount> {

    /**
     * 根据商户编号获取结算银行卡信息
     *
     * @param userNo
     * @return
     */
    UserBankAccount getSettlementBankAccountByMerchantUserNo(String userNo);

    /**
     * 根据会员编号获取用户快捷支付银行卡账户信息列表
     *
     * @param userNo
     * @return
     */
    List<UserBankAccount> listFastBankAccountByMerchantUserNo(String userNo);

    /**
     * 根据会员编号获取会员结算银行卡账户信息列表
     *
     * @param userNo
     * @return
     */
    List<UserBankAccount> listSettlementBankAccountByMemberUserNo(String userNo);

    /**
     * 根据银行卡账号、用户编号获取银行卡信息
     *
     * @param bankAccountNo
     * @param userNo
     * @return
     */
    UserBankAccount getByBankAccountNoAndUserNo(String bankAccountNo, String userNo);

    /**
     * 根据用户名称、银行卡号，证件账号修改银行账户信息
     *
     * @param userName
     * @param accountNo
     * @param certNo
     * @param authStatus
     * @return
     */
    long updateUserBankAccount(String userName, String accountNo, String certNo, int authStatus);
}
