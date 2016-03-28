package com.lhs.pay.common.core.mybatis.interceptor;

import com.lhs.pay.common.core.mybatis.dialect.Dialect;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * ExecutorInterceptor
 *
 * @author longhuashen
 * @since 16/3/22
 */
public class ExecutorInterceptor extends AbstractInterceptor {

    private static final Logger logger = Logger.getLogger(ExecutorInterceptor.class);

    private static int MAPPED_STATEMENT_INDEX = 0;

    private static int PARAMETER_INDEX = 1;

    private static int ROWBOUNDS_INDEX = 2;

    private Dialect dialect;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        processIntercept(invocation.getArgs());
        return invocation.proceed();
    }

    private void processIntercept(Object[] queryArgs) {
        MappedStatement mappedStatement = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];

        Object parameter = queryArgs[PARAMETER_INDEX];
        RowBounds rowBounds = (RowBounds) queryArgs[ROWBOUNDS_INDEX];

        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();

        //分页
        if (dialect.supportLimit() && (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);

            String sql = boundSql.getSql().replaceAll("\\s{2,}", " ").trim();
            if (dialect.supportLimitOffset()) {
                sql = dialect.getLimitString(sql, offset, limit);
                offset = RowBounds.NO_ROW_OFFSET;
            } else {
                sql = dialect.getLimitString(sql, 0, limit);
            }

            limit = RowBounds.NO_ROW_LIMIT;

            queryArgs[ROWBOUNDS_INDEX] = new RowBounds(offset, limit);
            BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql), false);
            queryArgs[MAPPED_STATEMENT_INDEX] = newMs;

            logger.debug("===>" + sql);
        } else if (parameter instanceof CountParameter) {
            //获取总数
            parameter = ((CountParameter) parameter).getParameter();
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);

            String sql = boundSql.getSql()
                                .replaceAll("\\s{2,}", " ")
                                .replace(" FROM", " from")
                                .replace("ORDER BY", "order by")
                                .replace("GROUP BY", "group by")
                                .trim();

            if (sql.split("from").length > 2 || sql.split("order by").length > 2 || sql.indexOf("group by") > -1) {
                sql = "select count(1) from (" + sql + ") tmp";
            } else {
                int fromIndex = sql.indexOf(" from");
                sql = "select count(1)" + sql.substring(fromIndex);

                int orderByIndex = sql.indexOf("order by");
                if (orderByIndex > 0) {
                    sql = sql.substring(0, orderByIndex);
                }
            }

            BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql), true);
            queryArgs[MAPPED_STATEMENT_INDEX] = newMs;
            queryArgs[PARAMETER_INDEX] = parameter;

            logger.debug("===>" + sql);
        }

        //行锁标识
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql().replace("\\s{2,}", " ").trim();

        if (sql.toLowerCase().endsWith("for update")) {

            if (this.dialect.getClass().getSimpleName().toLowerCase().endsWith("db2dialect")) {
                sql += "with rs";
            } else if (this.dialect.getClass().getSimpleName().toLowerCase().endsWith("oracledialect")) {

            } else if (this.dialect.getClass().getSimpleName().toLowerCase().endsWith("mysqldialect")) {

            }

            queryArgs[ROWBOUNDS_INDEX] = new RowBounds(offset, limit);
            BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql), false);
            queryArgs[MAPPED_STATEMENT_INDEX] = newMs;

            logger.debug("===>" + sql);
        }
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    public static class CountParameter {
        private Object parameter;

        public CountParameter(Object parameter) {
            this.parameter = parameter;
        }

        public Object getParameter() {
            return parameter;
        }
    }
}
