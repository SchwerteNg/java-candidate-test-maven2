package com.example.demo.common;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    private static JedisPool pool;
    private static Integer maxTotal = Integer.parseInt("20");
    private static Integer maxIdle = Integer.parseInt("20");
    private static Integer minIdle = Integer.parseInt("20");

    private static Boolean testOnBorrow = Boolean.parseBoolean("true");
    private static Boolean testOnReturn = Boolean.parseBoolean("false");

    private static String redisIp = "IP";
    private static Integer redisPort = Integer.parseInt("6379");
    private static String redisPassword = "Password";

    private static void initPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setBlockWhenExhausted(true);
        pool = new JedisPool(config,redisIp,redisPort,1000*2,redisPassword,0);
    }
    static{
        initPool();
    }
    public static Jedis getJedis(){
        return pool.getResource();
    }
    public static void returnBrokenResource(Jedis jedis){
        pool.returnBrokenResource(jedis);
    }
    public static void returnResource(Jedis jedis){
        pool.returnResource(jedis);
    }

}
