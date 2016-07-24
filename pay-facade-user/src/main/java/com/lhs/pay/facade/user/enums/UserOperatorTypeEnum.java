package com.lhs.pay.facade.user.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserOperatorTypeEnum
 *
 * @author longhuashen
 * @since 16/7/24
 */
public enum UserOperatorTypeEnum {

    ADMIN("管理员", 1),
    USER("普通用户", 2);

    /** 描述 */
    private String desc;
    /** 枚举值 */
    private int value;

    private UserOperatorTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
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

    public static UserOperatorTypeEnum getEnum(int value){
        UserOperatorTypeEnum resultEnum = null;
        UserOperatorTypeEnum[] enumAry = UserOperatorTypeEnum.values();
        for(int i = 0;i<enumAry.length;i++){
            if(enumAry[i].getValue() == value){
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        UserOperatorTypeEnum[] ary = UserOperatorTypeEnum.values();
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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List toList(){
        UserOperatorTypeEnum[] ary = UserOperatorTypeEnum.values();
        List list = new ArrayList();
        for(int i=0;i<ary.length;i++){
            Map<String,String> map = new HashMap<>();
            map.put("value",String.valueOf(ary[i].getValue()));
            map.put("desc", ary[i].getDesc());
            list.add(map);
        }
        return list;
    }
}
