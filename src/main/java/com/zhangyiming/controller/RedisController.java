package com.zhangyiming.controller;

import com.zhangyiming.pojo.IMoocJSONResult;
import com.zhangyiming.pojo.User;
import com.zhangyiming.utils.JsonUtils;
import com.zhangyiming.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\14 001420:54
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public IMoocJSONResult test() {
        return null;
    }

    @RequestMapping("/getJsonList")
    public IMoocJSONResult getJsonList() {
        return null;
    }

}