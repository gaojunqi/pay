package com.lhs.pay.facade.account.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AccountFundDirectionEnum
 *
 * 资金变动方向
 *
 * @author longhuashen
 * @since 16/5/18
 */
public enum AccountFundDirectionEnum {

    ADD("加款", 123),

    SUB("减款", 321),

    FROZEN("冻结", 321),

    UNFROZEN("解冻", 123);

    /**
     * 枚举值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    AccountFundDirectionEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
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

    public static AccountFundDirectionEnum getEnum(int value) {
        AccountFundDirectionEnum resultEnum = null;
        AccountFundDirectionEnum[] enumArray = AccountFundDirectionEnum.values();
        for (int num = 0; num < enumArray.length; num++) {
            if (enumArray[num].getValue() == value) {
                resultEnum = enumArray[num];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        AccountFundDirectionEnum[] ary = AccountFundDirectionEnum.values();
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
        AccountFundDirectionEnum[] ary = AccountFundDirectionEnum.values();
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
