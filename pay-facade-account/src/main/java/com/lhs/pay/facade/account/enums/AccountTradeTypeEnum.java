package com.lhs.pay.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountTradeTypeEnum
 * <p/>
 * 交易码，账户服务专用
 *
 * @author longhuashen
 * @since 16/5/18
 */
public enum AccountTradeTypeEnum {

    SPLIT("分账", 1001),

    ACCOUNT_TRANSFER("会员转账", 2001),

    ACCOUNT_DEPOSIT("会员充值", 3001),

    NET_B2C_REFUND("B2C网银退款", 4001),

    NET_B2B_REFUND("B2B网银退款", 4002),

    DEPOSIT_FAILD_REFUND("充值失败退款", 4003),

    FAST_REFUND("快捷支付退款", 4004),

    ACCOUNT_BALANCE_REFUND("会员余额支付退款", 4005),

    POS_REFUND("POS退货", 4008),

    SPLIT_REFUND("分账退款", 4009),

    CASH_REFUND("现金支付退款", 4010),

    POS_RECHARGE("POS充值", 4013),

    SETTLEMENT("结算", 5001),

    ATM("提现", 5002),

    SETTLEMENT_INTO("结算到账", 5003),

    ATM_INTO("提现到账", 5004),

    NET_B2C_PAY("B2C银行卡支付", 6001),

    NET_B2B_PAY("B2B银行卡支付", 6002),

    FAST_PAY("快捷支付", 6004),

    ACCOUNT_BALANCE_PAY("余额支付", 6005),

    POS_PAY("POS消费", 6006),

    CASH_PAY("现金支付", 6007),

    REMIT("打款", 7001),

    ACCOUNTING_DAILY_CUT("会计日终", 8001),

    ACCOUNT_ADJUST("账户调账", 9001),

    MERCHANT_RECON("商户认账", 1101),

    BANK_MORE_PLAT_RECON("银行长款平台认账", 1102),

    BANK_LESS_PLAT_RECON("银行短款平台认账", 1103),

    BANK_MORE_NOT_MATCH_BANK_RECON("银行长款金额不符银行认账", 1104),

    CASH_PAY_RECON("现金支付入账", 1105),

    ACCOUNT_AGENCYDEBIT("代扣", 1106);

    /**
     * 描述
     */
    private String desc;

    /**
     * 枚举值
     */
    private int value;

    AccountTradeTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static AccountTradeTypeEnum getEnum(int value) {
        AccountTradeTypeEnum accountTypeEnum = null;
        AccountTradeTypeEnum[] enumArray = AccountTradeTypeEnum.values();
        for (int num = 0; num < enumArray.length; num++) {
            if (enumArray[num].getValue() == value) {
                accountTypeEnum = enumArray[num];
                break;
            }
        }
        return accountTypeEnum;
    }

    /**
     * 将枚举类转换为map.
     *
     * @return Map<key, Map<attr, value>>
     */
    public static Map<String, Map<String, Object>> toMap() {
        AccountTradeTypeEnum[] ary = AccountTradeTypeEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(ary[num].getValue()));
            map.put("value", ary[num].getValue());
            map.put("desc", ary[num].getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    /**
     * 将枚举类转换为list.
     *
     * @return List<Map<String, Object>> list.
     */
    public static List<Map<String, Object>> toList() {
        AccountTradeTypeEnum[] ary = AccountTradeTypeEnum.values();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < ary.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", ary[i].getValue());
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }
}
