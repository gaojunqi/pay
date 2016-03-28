package com.lhs.pay.common.core.dao;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * BaseDao
 *
 * 数据访问层基础支撑接口
 *
 * @author longhuashen
 * @since 16/3/21
 */
public interface BaseDao<T> {

    /**
     * 添加记录
     *
     * @param entity
     * @return
     */
    long insert(T entity);

    /**
     * 批量添加记录
     *
     * @param list
     * @return
     */
    long insert(List<T> list);

    /**
     * 更新记录
     *
     * @param entity
     * @return
     */
    long update(T entity);

    /**
     * 批量更新记录
     *
     * @param list
     * @return
     */
    long update(List<T> list);

    /**
     * 根据id查找记录
     *
     * @param id
     * @return
     */
    T getById(long id);

    /**
     * 根据id删除记录
     *
     * @param id
     * @return
     */
    long deleteById(long id);

    /**
     * 分页查询
     *
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);

    /**
     * 根据条件查询
     *
     * @param paramMap
     * @return 集合
     */
    List<T> listBy(Map<String, Object> paramMap);

    List<Object> listBy(Map<String, Object> paramMap, String sqlId);

    /**
     * 根据条件查询
     *
     * @param paramMap
     * @return 实体
     */
    T getBy(Map<String, Object> paramMap);

    Object getBy(Map<String, Object> paramMap, String sqlId);

    /**
     * 根据序列名称获取下一个值
     *
     * @param seqName
     * @return
     */
    String getSeqNextValue(String seqName);

    SqlSessionTemplate getSessionTemplate();

    SqlSession getSqlSession();
}
