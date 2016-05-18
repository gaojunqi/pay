package com.lhs.pay.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountTypeEnum
 * <p/>
 * 账户类型，适用于账户表
 *
 * @author longhuashen
 * @since 16/5/18
 */
public enum AccountTypeEnum {

    MERCHANT("在线商户", 1),

    AGENT("代理商", 2),

    CUSTOMER("个人/会员", 3),

    PRIVATE("内部账户", 4),

    POS("POS商户", 5),

    POSAGENT("POS代理商", 6),

    POS_OUT_SETT("POS商户_外部结算", 7);

    /**
     * 描述
     */
    private String desc;

    /**
     * 枚举值
     */
    private int value;

    AccountTypeEnum(String desc, int value) {
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

    public static AccountTypeEnum getEnum(int value) {
        AccountTypeEnum accountTypeEnum = null;
        AccountTypeEnum[] enumArray = AccountTypeEnum.values();
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
        AccountTypeEnum[] ary = AccountTypeEnum.values();
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
        AccountTypeEnum[] ary = AccountTypeEnum.values();
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
