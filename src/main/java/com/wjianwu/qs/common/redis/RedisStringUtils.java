package com.wjianwu.qs.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wjianwu 2019/2/28 10:29
 * 操作 String 键
 */
@Component
public class RedisStringUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取缓存
     *
     * @param key 键
     * @return true or false
     */
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置键值对
     *
     * @param key   键
     * @param value 值
     * @return true or false
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            System.err.println("设置键值对异常，设置失败！");
        }
        return result;
    }

    /**
     * 更新键值对
     *
     * @param key   键
     * @param value 值
     * @return true or false
     */
    public boolean reset(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            System.err.println("更新键值对异常，设置失败！");
        }
        return result;
    }

    /**
     * 删除键值对
     *
     * @param key 键
     * @return true or false
     */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            System.err.println("删除键值对异常，设置失败！");
        }
        return result;
    }
}
