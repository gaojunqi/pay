package com.lhs.pay.common.enums;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OperatorStatusEnum
 *
 * @author longhuashen
 * @since 16/4/10
 */
public enum OperatorStatusEnum {

    ACTIVE("激活", 100),
    INACTIVE("冻结", 101);

    /**
     * 秒速
     */
    private String desc;

    /**
     * 枚举值
     */
    private int value;

    private OperatorStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static OperatorStatusEnum getEnum(int value) {
        OperatorStatusEnum resultEnum = null;
        OperatorStatusEnum[] enumArr = OperatorStatusEnum.values();
        for (int i = 0; i < enumArr.length; i++) {
            if (enumArr[i].getValue() == value) {
                resultEnum = enumArr[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        OperatorStatusEnum[] ary = OperatorStatusEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<>();
            String key = String.valueOf(getEnum(ary[num].getValue()));
            map.put("value", String.valueOf(ary[num].getValue()));
            map.put("desc", ary[num].getDesc());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public static List toList() {
        OperatorStatusEnum[] ary = OperatorStatusEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", String.valueOf(ary[i].getValue()));
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
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
}
