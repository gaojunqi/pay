package com.lhs.pay.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountStatusEnum
 *
 * 账户状态
 *
 * @author longhuashen
 * @since 16/5/18
 */
public enum AccountStatusEnum {

    ACTIVE("激活", 100),

    INACTIVE("冻结", 101),

    INACTIVE_FREEZE_CREDIT("冻结止收", 102),

    INACTIVE_FREEZE_DEBIT("冻结止付", 103),

    CANCELLED("注销", 104);

    /**
     * 描述
     */
    private String desc;

    /**
     * 枚举值
     */
    private int value;

    AccountStatusEnum(String desc, int value) {
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

    public static AccountStatusEnum getEnum(int value) {
        AccountStatusEnum accountTypeEnum = null;
        AccountStatusEnum[] enumArray = AccountStatusEnum.values();
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
        AccountStatusEnum[] ary = AccountStatusEnum.values();
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
        AccountStatusEnum[] ary = AccountStatusEnum.values();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < ary.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", ary[i].getValue());
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }

    public static List toAccountStatusList() {
        AccountStatusEnum[] ary = AccountStatusEnum.values();
        List list = new ArrayList();
        int value[] = {101, 102, 103};
        for(int i = 0; i < ary.length; i++) {
            int val = ary[i].getValue();
            for (int v : value) {
                if (v == val) {
                     Map<String, Object> map = new HashMap<>();
                     map.put("value", String.valueOf(val));
                     map.put("desc", ary[i].getDesc());
                     list.add(map);
                }
            }
        }
        return list;
    }
}
