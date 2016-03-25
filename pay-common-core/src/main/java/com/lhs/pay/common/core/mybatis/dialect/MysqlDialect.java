package com.lhs.pay.common.core.mybatis.dialect;

/**
 * MysqlDialect
 *
 * @author longhuashen
 * @since 16/3/25
 */
public class MysqlDialect extends Dialect {

    @Override
    public boolean supportLimit() {
        return true;
    }

    @Override
    public boolean supportLimitOffset() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        if (offset > 0) {
            sql += " limit " + offsetPlaceholder + " ," + limitPlaceholder;
        } else {
            sql += " limit" + limitPlaceholder;
        }

        return sql;
    }
}
