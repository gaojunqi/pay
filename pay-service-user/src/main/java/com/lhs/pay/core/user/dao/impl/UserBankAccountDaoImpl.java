package com.lhs.pay.core.user.dao.impl;

import com.lhs.pay.common.core.dao.BaseDaoImpl;
import com.lhs.pay.common.enums.BankAccountTypeEnum;
import com.lhs.pay.common.enums.PublicStatusEnum;
import com.lhs.pay.core.user.dao.IUserBankAccountDao;
import com.lhs.pay.facade.user.entity.UserBankAccount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserBankAccountDaoImpl
 *
 * @author longhuashen
 * @since 16/7/2
 */
@Repository("userBankAccountDao")
public class UserBankAccountDaoImpl extends BaseDaoImpl<UserBankAccount> implements IUserBankAccountDao {

    @Override
    public UserBankAccount getSettlementBankAccountByMerchantUserNo(String userNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("isDefault", PublicStatusEnum.ACTIVE.getValue());
        paramMap.put("isDelete", PublicStatusEnum.INACTIVE.getValue());
        return super.getBy(paramMap);
    }

    @Override
    public List<UserBankAccount> listFastBankAccountByMerchantUserNo(String userNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("isDelete", PublicStatusEnum.INACTIVE.getValue());
        paramMap.put("isAuth", PublicStatusEnum.ACTIVE.getValue());
        return super.listBy(paramMap);
    }

    @Override
    public List<UserBankAccount> listSettlementBankAccountByMemberUserNo(String userNo) {
        Map<String , Object> paramMap = new HashMap<String , Object>();
        paramMap.put("userNo", userNo);
        paramMap.put("isDelete", PublicStatusEnum.INACTIVE.getValue());
        paramMap.put("bankAccountType", BankAccountTypeEnum.PRIVATE_DEBIT_CARD.getValue());
        return super.listBy(paramMap);
    }

    @Override
    public UserBankAccount getByBankAccountNoAndUserNo(String bankAccountNo, String userNo) {
        Map<String , Object> paramMap = new HashMap<>();
        paramMap.put("userNo", userNo);
        paramMap.put("bankAccountNo", bankAccountNo);
        return super.getBy(paramMap);
    }

    @Override
    public long updateUserBankAccount(String userName, String accountNo, String certNo, int authStatus) {
        Map<String , Object> paramMap = new HashMap<>();
        paramMap.put("bankAccountName", userName);
        paramMap.put("bankAccountNo", accountNo);
        paramMap.put("cardNo", certNo);
        paramMap.put("isAuth", authStatus);

        return super.getSessionTemplate().update("updateAuthStatusByUserNameAndAccountNo", paramMap);
    }
}
