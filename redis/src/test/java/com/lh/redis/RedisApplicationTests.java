package com.lh.redis;

import com.lh.redis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
class RedisApplicationTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void connectTest() {
        redisUtil.set("lhtest", "100", 30);
        System.out.println(redisUtil.getExpire("lhtest"));
    }

}
