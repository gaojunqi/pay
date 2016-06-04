package com.lhs.pay.facade.user.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserAuditStatusEnum
 *
 * 用户审核状态
 *
 * @author longhuashen
 * @since 16/6/4
 */
public enum UserAuditStatusEnum {

    AGREE("同意", 100), REFUSE("拒绝", 101), WAIT("处理中", 102);

    private int value;

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

    UserAuditStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserAuditStatusEnum getEnum(int value) {
        UserAuditStatusEnum resultEnum = null;
        UserAuditStatusEnum[] enumArray = UserAuditStatusEnum.values();
        for (int i = 0; i < enumArray.length; i++) {
            if (enumArray[i].getValue() == value) {
                resultEnum = enumArray[i];
                break;
            }
        }
        return resultEnum;
    }

    public static List toList() {
        UserAuditStatusEnum[] arrayEnum = UserAuditStatusEnum.values();
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
        UserAuditStatusEnum[] ary = UserAuditStatusEnum.values();
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
