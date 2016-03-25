package com.lhs.pay.common.core.mybatis.cache.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * CachePool
 *
 * Redis初始化与连接池实现
 * 与结合mybatis实现，不与Spring redis注解实现混用
 *
 * @author longhuashen
 * @since 16/3/25
 */
public class CachePool {

    private JedisSentinelPool jedisSentinelPool;

    public JedisSentinelPool getJedisSentinelPool() {
        return this.jedisSentinelPool;
    }

    private static final CachePool cachePool = new CachePool();

    //private RedisUtils redisUtils = new RedisUtils();

    public static CachePool getInstance() {
        return cachePool;
    }

    private CachePool() {
        //jedisSentinelPool = re
    }

    public Jedis getJedis() {
        Jedis jedis = null;
        boolean borrowOrOprSuccess = true;

        try {
            jedis = jedisSentinelPool.getResource();
        } catch (JedisConnectionException e) {
                borrowOrOprSuccess = false;
                if (jedis != null) {
                    jedisSentinelPool.returnBrokenResource(jedis);
                }
        } finally {
            jedis = jedisSentinelPool.getResource();
            return jedis;
        }
    }
}
