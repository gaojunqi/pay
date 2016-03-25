package com.lhs.pay.common.core.mybatis.interceptor;

import org.apache.ibatis.mapping.*;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.Interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractInterceptor
 *
 * Mybatis拦截器基类
 *
 * @author longhuashen
 * @since 16/3/22
 */
public abstract class AbstractInterceptor implements Interceptor {

    protected MappedStatement copyFromMappedStatement(MappedStatement mappedStatement, SqlSource sqlSource, boolean isCount) {
        Builder builder = new MappedStatement.Builder(mappedStatement.getConfiguration(), mappedStatement.getId(), sqlSource, mappedStatement.getSqlCommandType());
        builder.resource(mappedStatement.getResource());
        builder.fetchSize(mappedStatement.getFetchSize());
        builder.statementType(mappedStatement.getStatementType());
        builder.keyGenerator(mappedStatement.getKeyGenerator());

        String[] s = mappedStatement.getKeyProperties();
        if (s == null) {
            builder.keyProperty(null);
        } else {
            builder.keyProperty(s[0]);
        }

        builder.timeout(mappedStatement.getTimeout());
        builder.parameterMap(mappedStatement.getParameterMap());

        if (isCount) {
            List<ResultMap> resultMaps = new ArrayList<>();
            resultMaps.add(new ResultMap.Builder(mappedStatement.getConfiguration(), mappedStatement.getId(), Integer.class, new ArrayList<ResultMapping>()).build());
            builder.resultMaps(resultMaps);
        } else {
            builder.resultMaps(mappedStatement.getResultMaps());
        }

        builder.cache(mappedStatement.getCache());
        return builder.build();
     }

    public static class BoundSqlSqlSource implements SqlSource {

        BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        @Override
        public BoundSql getBoundSql(Object o) {
            return boundSql;
        }
    }

}
