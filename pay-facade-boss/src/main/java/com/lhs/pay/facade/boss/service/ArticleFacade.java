package com.lhs.pay.facade.boss.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.boss.entity.Article;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.List;
import java.util.Map;

/**
 * ArticleFacade
 *
 * 文章公告等发布接口
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface ArticleFacade {

    long create(Article entity) throws BossBizException;

    long update(Article entity) throws BossBizException;

    Article getById(long id) throws BossBizException;

    Article getBy(Map<String, Object> map) throws BossBizException;

    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws BossBizException;

    List<Article> listBy(Map<String, Object> paramMap);
}
