package com.lh.redis.service;

import com.lh.redis.config.RedisConfig;
import com.lh.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RedisService
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/29 11:32
 * @Version: 1.0
 **/
@Service
public class RedisService {
    @Autowired
    RedisUtil redisUtil;

    /**
     * @param key key
     * @return 获取指定key
     */
    public Object get(String key){
        return redisUtil.get(key);
    }

    /**
     * @param key key
     * @param value value
     */
    public Boolean set(String key,Object value){
        return redisUtil.set(key, value);
    }

    /**
     * @param key KEY
     * @param value value
     * @param time 设置过期时间 单位秒
     * @return 是否成功
     */
    public Boolean setExpireTime(String key,Object value,Long time){
        return redisUtil.set(key, value, time);
    }

}
