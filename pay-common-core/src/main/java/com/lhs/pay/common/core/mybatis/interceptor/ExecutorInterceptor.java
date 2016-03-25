package com.lhs.pay.common.core.mybatis.interceptor;

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

    //private Dialet

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        processIntercept(invocation.getArgs());
        return invocation.proceed();
    }

    private void processIntercept(Object[] args) {
        MappedStatement mappedStatement = (MappedStatement) args[MAPPED_STATEMENT_INDEX];

        Object parameter = args[PARAMETER_INDEX];
        RowBounds rowBounds = (RowBounds) args[ROWBOUNDS_INDEX];

        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();

//        if () {
//
//        }
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
