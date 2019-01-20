---
title: 基于Redis封装分布式锁
date: 2018.06.15 10:24:04
tags: Java、Redis
---
### 基于Redis的分布式锁封装记录
* 首先搭建一个基于Redis Server端（略过）
* Redis客户端连接池工具类（RedisPool.java）的封装<!--more-->
    *  利用类的static块初始化连接池
    *  初始化的参数包含最大连接数、最大空闲连接数、最小空闲连接数等基本参数
![image.png](https://upload-images.jianshu.io/upload_images/12666638-8f63f6d7efae78b7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
* 初始化连接池时读取mvc.default.properties配置文件中的jedis-pool配置，该配置值格式为:host,port连接到redis中，后续项目中可配置此自定义
* 封装的加锁操作分为非阻塞锁和阻塞锁，阻塞锁下封装了自定义失效时间锁和默认失效时间（10s）锁
``` java
Jedis jedis = RedisPool.getJedis();
String result = jedis.set(key, request, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
RedisPool.close(jedis);
``` 
*  阻塞锁的实现基于for(;;)循环，防止Cpu一直消耗，在循环体内加入Thread.sleep()保证时间片切换
``` java
for (;;) {
  Jedis jedis = RedisPool.getJedis();
  String result = jedis.set(key, request, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 10 * TIME);
  RedisPool.close(jedis);
  if (LOCK_SUCCESS.equals(result)) {
    break;
  }
  // 防止一直消耗 CPU
  Thread.sleep(100);
}
``` 
* 释放锁时需要调用Lua脚本来完成，传统的释放锁会涉及get到资源，然后del掉，使用Java client语法操作两个步骤不能保障原子性，所以在此采用Lua脚本来保证get和del为原子操作
``` java
public static boolean unlock(String key, String request) {
  String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
  Jedis jedis = RedisPool.getJedis();
  Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(request));
  RedisPool.close(jedis);
  if (RELEASE_SUCCESS.equals(result)) {
    return true;
  }
  return false;
}
``` 
