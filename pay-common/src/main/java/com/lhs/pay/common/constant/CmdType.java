package com.lhs.pay.common.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * CmdType
 *
 * 接口类型
 *
 * @author longhuashen
 * @since 16/3/26
 */
public enum CmdType {

    B2C {
        @Override
        public String getDesc() {
            return "B2C";
        }
    },B2B {
        @Override
        public String getDesc() {
            return "B2B";
        }
    },Buy {
        @Override
        public String getDesc() {
            return "订单创建";
        }
    },OrderQuery {
        @Override
        public String getDesc() {
            return "订单查询";
        }
    },OrderRefund {
        @Override
        public String getDesc() {
            return "订单退款";
        }
    };

    public abstract String getDesc();

    public static Map<String, String> toStringMap() {
        CmdType[] type = values();
        Map<String, String> map = new LinkedHashMap<>();

        if (type != null) {
            for (CmdType e : type) {
                map.put(e.toString(), e.getDesc());
            }
        }
        return map;
    }
}
