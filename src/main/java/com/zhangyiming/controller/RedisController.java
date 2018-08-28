package com.zhangyiming.controller;

import com.zhangyiming.pojo.IMoocJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\14 001420:54
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public String test() {
        redisTemplate.opsForValue().set("userName", "hello zhangyiming");
        return String.valueOf(redisTemplate.opsForValue().get("userName"));
    }

    @RequestMapping("/getJsonList")
    public IMoocJSONResult getJsonList() {
        return null;
    }

}