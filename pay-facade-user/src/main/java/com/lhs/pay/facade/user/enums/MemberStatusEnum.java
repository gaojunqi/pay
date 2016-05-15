package com.lhs.pay.facade.user.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MemberStatusEnum
 *
 * @author longhuashen
 * @since 16/5/15
 */
public enum MemberStatusEnum {

    ACTIVE("激活" ,100), INACTIVE("冻结", 101), SINGING("注册中", 104), CLOSE("已注销", 105);

    /**
     * 枚举值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

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

    MemberStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static MemberStatusEnum getEnum(int value) {
        MemberStatusEnum resultEnum = null;
        MemberStatusEnum[] enumArray = MemberStatusEnum.values();
        for (int i = 0; i < enumArray.length; i++) {
            if (enumArray[i].getValue() == value) {
                resultEnum = enumArray[i];
                break;
            }
        }
        return resultEnum;
    }

    public static List toList() {
        MemberStatusEnum[] arrayEnum = MemberStatusEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < arrayEnum.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("value", String.valueOf(arrayEnum[i].getValue()));
            map.put("desc", arrayEnum[i].getDesc());
            list.add(map);
        }
        return list;
    }

    public static Map<String, Map<String, Object>> toMap() {
        MemberStatusEnum[] ary = MemberStatusEnum.values();
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

}
