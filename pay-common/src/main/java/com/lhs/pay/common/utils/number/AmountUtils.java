package com.lhs.pay.common.utils.number;

import java.math.BigDecimal;

/**
 * AmountUtils
 *
 * @author longhuashen
 * @since 16/5/24
 */
public abstract class AmountUtils {

    private AmountUtils() {}

    /**
     * 加法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 减法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 判断a 是否大于等于b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean greaterThanOrEqualTo(double a, double b) {
        BigDecimal v1 = BigDecimal.valueOf(a);
        BigDecimal v2 = BigDecimal.valueOf(b);
        if (v1.compareTo(v2) >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断a是否大于b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean bigger(double a, double b) {
        BigDecimal v1 = BigDecimal.valueOf(a);
        BigDecimal v2 = BigDecimal.valueOf(b);
        if (v1.compareTo(v2) == 1) {
            return true;
        }
        return false;
    }
}
