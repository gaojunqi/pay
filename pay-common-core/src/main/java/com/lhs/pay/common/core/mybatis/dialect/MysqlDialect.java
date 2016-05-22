package com.lhs.pay.common.core.mybatis.dialect;

/**
 * MysqlDialect
 *
 * @author longhuashen
 * @since 16/5/22
 */
public class MysqlDialect extends Dialect {



    public boolean supportsLimitOffset() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {

        if (offset > 0) {
            sql += " limit " + offsetPlaceholder + "," + limitPlaceholder;
        } else {
            sql += " limit " + limitPlaceholder;
        }

        return sql;
    }
}
