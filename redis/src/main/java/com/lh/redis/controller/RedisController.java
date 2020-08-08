package com.lh.redis.controller;

import com.lh.redis.dto.SetReqDto;
import com.lh.redis.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Home redirection to swagger api documentation 
 */
@RestController
@Log4j2
public class RedisController {
    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/{key}",method = RequestMethod.GET)
    public Object index(@PathVariable String key) {
        return redisService.get(key);
    }

    @PostMapping(value = "/set")
    public ResponseEntity<Void> setKey(@RequestBody SetReqDto reqDto){
        redisService.set(reqDto.getKey(), reqDto.getValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/setExpireTime")
    public ResponseEntity<Void> setKeyWithExpirtTime(@RequestBody SetReqDto reqDto){
        redisService.setExpireTime(reqDto.getKey(), reqDto.getValue(), reqDto.getExpireTime());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
