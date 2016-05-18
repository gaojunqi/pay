package com.lhs.pay.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountInitiatorEnum
 * <p/>
 * 账户操作，发起方
 *
 * @author longhuashen
 * @since 16/5/18
 */
public enum AccountInitiatorEnum {

    RCMS_SYS("风控系统", 1),

    BOSS_SYS("运营BOSS", 2),

    USER_REG("用户注册", 3);

    /**
     * 枚举值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    AccountInitiatorEnum(String desc, int value) {
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

    public static AccountInitiatorEnum getEnum(int value) {
        AccountInitiatorEnum resultEnum = null;
        AccountInitiatorEnum[] enumArray = AccountInitiatorEnum.values();
        for (int num = 0; num < enumArray.length; num++) {
            if (enumArray[num].getValue() == value) {
                resultEnum = enumArray[num];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountInitiatorEnum[] ary = AccountInitiatorEnum.values();
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
        AccountInitiatorEnum[] ary = AccountInitiatorEnum.values();
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
