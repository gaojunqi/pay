package com.lhs.pay.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountOperationTypeEnum
 *
 * @author longhuashen
 * @since 16/5/18
 */
public enum AccountOperationTypeEnum {

    FREEZE_DEBIT("冻结支付", 1),

    UNFREEZE_DEBIT("解冻支付", 2),

    FREEZE_CREDIT("冻结止收", 3),

    UNFREEZE_CREDIT("解冻止收", 4),

    FREEZE_ACCOUNT("冻结账户", 5),

    UNFREEZE_ACCOUNT("解冻账户", 6),

    CREATE_ACCOUNT("创建付款账户", 7),

    FREEZE_FUND("冻结资金", 8),

    UNFEEZE_FUND("解冻资金", 9),

    CANCLE_ACCOUNT("注销账户", 10);

    /**
     * 枚举值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    AccountOperationTypeEnum(String descj, int value) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static AccountOperationTypeEnum getEnum(int value) {
        AccountOperationTypeEnum resultEnum = null;
        AccountOperationTypeEnum[] enumArray = AccountOperationTypeEnum.values();
        for (int num = 0; num < enumArray.length; num++) {
            if (enumArray[num].getValue() == value) {
                resultEnum = enumArray[num];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountOperationTypeEnum[] ary = AccountOperationTypeEnum.values();
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
        AccountOperationTypeEnum[] ary = AccountOperationTypeEnum.values();
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
