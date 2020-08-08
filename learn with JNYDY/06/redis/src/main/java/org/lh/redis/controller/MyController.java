package org.lh.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MyController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/8/3 17:31
 * @Version: 1.0
 **/
@RestController
public class MyController {

    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping("/set")
    public void set(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("ss", "learn spring boot");

    }

    @GetMapping("/get")
    public void get(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String res = ops.get("lh");
        System.out.println(res);

    }
}
