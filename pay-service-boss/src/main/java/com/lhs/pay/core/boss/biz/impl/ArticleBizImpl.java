package com.lhs.pay.core.boss.biz.impl;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.core.boss.biz.IArticleBiz;
import org.apache.commons.net.nntp.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ArticleBizImpl
 *
 * @author longhuashen
 * @since 16/8/2
 */
@Service("articleBiz")
public class ArticleBizImpl implements IArticleBiz {

    @Override
    public long create(Article entity) {
        return 0;
    }

    @Override
    public long update(Article entity) {
        return 0;
    }

    @Override
    public Article getById(long id) {
        return null;
    }

    @Override
    public Article getBy(Map<String, Object> map) {
        return null;
    }

    @Override
    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public List<Article> listBy(Map<String, Object> paramMap) {
        return null;
    }
}
