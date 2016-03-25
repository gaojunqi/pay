package com.lhs.pay.common.core.dao;


import com.alibaba.druid.pool.DruidDataSource;
import com.lhs.pay.common.entity.BaseEntity;
import com.lhs.pay.common.exceptions.BizException;
import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseDaoImpl
 *
 * 数据访问层基础支撑接口实现类
 *
 * @author longhuashen
 * @since 16/3/21
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    public static final String SQL_INSERT = "insert";

    public static final String SQL_BATCH_INSERT = "batchInsert";

    public static final String SQL_UPDATE = "update";

    public static final String SQL_GET_BY_ID = "getById";

    public static final String SQL_DELETE_BY_ID = "deleteById";

    public static final String SQL_LIST_PAGE = "listPage";

    /**
     * 根据当前分页参数进行统计
     */
    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private DruidDataSource druidDataSource;


    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public long insert(T entity) {
        if (entity == null) {
            throw new RuntimeException("T is null");
        }

        int result = sqlSessionTemplate.insert(getStatement(SQL_INSERT), entity);

        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0;
        }

        if (entity != null && entity.getId() != null && result > 0) {
            return entity.getId();
        }
        return result;
    }

    private String getStatement(String sqlId) {
        String name = this.getClass().getName();

        StringBuffer sb = new StringBuffer().append(name).append(".").append(sqlId);

        return sb.toString();
    }

    @Override
    public long insert(List<T> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int result = sqlSessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

        if (result <= 0) {
             throw BizException.DB_INSERT_RESULT_0;
        }
        return result;
    }

    @Override
    public long update(T entity) {
        if (entity == null) {
            throw new RuntimeException("entity is null");
        }

        int result = sqlSessionTemplate.update(getStatement(SQL_UPDATE), entity);
        if (result <= 0) {
            throw BizException.DB_UPDATE_RESULT_0;
        }
        return result;
    }

    @Override
    public long update(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }

        int result = 0;
        for (int i =0; i < list.size(); i++) {
            this.update(list.get(i));
            result++;
        }
        return result;
    }

    @Override
    public T getById(long id) {
        return sqlSessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
    }

    @Override
    public long deleteById(long id) {
        return (long) sqlSessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
        if (pageParam == null) {
            paramMap = new HashMap<String, Object>();
        }

        //获取分页数据
        List<Object> list = getSqlSession().selectList(getStatement(sqlId), paramMap
                , new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));

        //统计总记录数
//        Object countObject = (Object) getSqlSession().selectOne(getStatement(sqlId), new ExecutorInterceptor.)
        return null;
    }

    @Override
    public List<T> listBy(Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public T getBy(Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public Object getBy(Map<String, Object> paramMap, String sqlId) {
        return null;
    }

    @Override
    public String getSeqNextValue(String seqName) {
        return null;
    }

    @Override
    public SqlSessionTemplate getSessionTemplate() {
        return null;
    }
}
