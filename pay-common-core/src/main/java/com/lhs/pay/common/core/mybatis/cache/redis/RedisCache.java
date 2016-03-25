package com.lhs.pay.common.core.mybatis.cache.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * RedisCache
 *
 * @author longhuashen
 * @since 16/3/25
 */
public class RedisCache implements Cache {

    private static Log log = LogFactory.getLog(RedisCache.class);

    private String id;

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("必须传入ID");
        }
        if (log.isDebugEnabled()) {
            log.debug("MybatisRedisCache:id=" + id);
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        Jedis jedis = null;
        return 0;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
