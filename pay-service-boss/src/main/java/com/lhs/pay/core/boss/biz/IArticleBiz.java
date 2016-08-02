package com.lhs.pay.core.boss.biz;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import org.apache.commons.net.nntp.Article;

import java.util.List;
import java.util.Map;

/**
 * IArticleBiz
 *
 * @author longhuashen
 * @since 16/8/2
 */
public interface IArticleBiz {

    long create(Article entity);

    long update(Article entity);

    Article getById(long id);

    Article getBy(Map<String, Object> map);

    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    List<Article> listBy(Map<String, Object> paramMap);
}
