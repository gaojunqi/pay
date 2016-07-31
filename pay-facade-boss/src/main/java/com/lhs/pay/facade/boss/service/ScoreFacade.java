package com.lhs.pay.facade.boss.service;

import com.lhs.pay.common.page.PageBean;
import com.lhs.pay.common.page.PageParam;
import com.lhs.pay.facade.boss.entity.Score;
import com.lhs.pay.facade.boss.exception.BossBizException;

import java.util.Map;

/**
 * ScoreFacade
 *
 * 积分管理接口
 *
 * @author longhuashen
 * @since 16/7/31
 */
public interface ScoreFacade {

    long createScore(Score score);

    long update(Score score);

    Score getBy(Map<String, Object> map) throws BossBizException;

    PageBean queryPage(PageParam pageParam, Map<String, Object> paramMap) throws BossBizException;

    long loginAddScore(String accountNo, Long score, String changeDesc) throws BossBizException;
}
