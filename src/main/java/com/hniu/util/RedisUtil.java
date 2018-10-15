package com.hniu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {


    @Autowired
    RedisTemplate redisTemplate;

    public void setObject(String key, Object value) {
        setObject(key,value ,null );
    }

    public void setObject(String key, Object value, Long time) {
        if (time == null)
            redisTemplate.opsForValue().set(key, value);
        else
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.HOURS);

    }

    public Object getObject(String key) {

        return redisTemplate.opsForValue().get(key);
    }

}
