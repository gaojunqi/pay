package com.lhs.pay.common.core.mybatis.dialect;

/**
 * Dialect
 *
 * @author longhuashen
 * @since 16/3/23
 */
public abstract class Dialect {

    public boolean supportLimit() {
        return false;
    }

    public boolean supportLimitOffset() {
        return supportLimit();
    }

    /**
     * 将sql变成分页sql语句，直接使用offset，limit的值作为占位符)
     *
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    public String getLimitString(String sql, int offset, int limit) {
        return getLimitString(sql, offset, Integer.toString(offset), limit, Integer.toString(limit));
    }

    /**
     * 将sql变成分页sql语句,提供将offset及limit使用占位符(placeholder)替换
     *
     * * <pre>
     * 如mysql
     * dialect.getLimitString("select * from user", 12, ":offset",0,":limit") 将返回
     * select * from user limit :offset,:limit
     * </pre>
     *
     * @param sql
     * @param offset
     * @param offsetPlaceholder
     * @param limit
     * @param limitPlaceholder
     * @return
     */
    public abstract String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder);
}
