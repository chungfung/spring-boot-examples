package com.chungfung.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;
/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/8 16:34
 * @Version 1.0
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.sentinel.master}")
    private String master;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.sentinel.nodes}")
    private String Sentinels;

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWait;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(@Autowired RedisSentinelConfiguration redisSentinelConfiguration) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisSentinelConfiguration);
        jedisConnectionFactory.setPassword(password);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration() {
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        redisSentinelConfiguration.setMaster(master);
        String[] sens = Sentinels.split(",");
        for (int i = 0; i < sens.length; i++) {
            String[] str = sens[i].split(":");
            RedisNode redisServer = new RedisServer(str[0], Integer.parseInt(str[1]));
            redisSentinelConfiguration.sentinel(redisServer);
        }
        return redisSentinelConfiguration;
    }

    /**
     * 哨兵
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    public JedisSentinelPool jedisSentinelPool(@Autowired JedisPoolConfig jedisPoolConfig) {
        String[] strs = Sentinels.split(",");
        Set set = new HashSet();
        for (int i = 0; i < strs.length; i++) {
            set.add(strs[i]);
        }
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(master, set, jedisPoolConfig, password);
        return jedisSentinelPool;
    }

    @Bean("jedisPoolConfig")
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(true);
        //在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(true);
        //获取连接是检查有效性
        jedisPoolConfig.setTestOnBorrow(true);
        //最大连接数
        jedisPoolConfig.setMaxTotal(maxActive);
        //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1800000);
        //最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setBlockWhenExhausted(true);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(minIdle);
        //逐出连接的最小空闲时间 默认1800000毫秒(15分钟)
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(900000);
        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        return jedisPoolConfig;
    }

    /**
     * jedisPool连接池统一通过redisUtil来获取连接
     * @param jedisSentinelPool
     * @param jedisPoolConfig
     * @return
     */
    @Bean("jedisPool")
    public JedisPool jedisPool(@Autowired JedisSentinelPool jedisSentinelPool,
                               @Autowired JedisPoolConfig jedisPoolConfig) {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, jedisSentinelPool.getCurrentHostMaster().getHost(),
                jedisSentinelPool.getCurrentHostMaster().getPort(), timeout, password);
        return jedisPool;
    }
}