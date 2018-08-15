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

        strRedis.opsForValue().set("imooc-cache", "hello 慕课网~~~~~~");

        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setUserid("007");
        user.setPassword("abc123");
        strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        User jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), User.class);

        return IMoocJSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public IMoocJSONResult getJsonList() {

//        User user = new User();
//        user.setAge(18);
//        user.setName("慕课网");
//        user.setPassword("123456");
//        user.setBirthday(new Date());
//
//        User u1 = new User();
//        u1.setAge(19);
//        u1.setName("imooc");
//        u1.setPassword("123456");
//        u1.setBirthday(new Date());
//
//        User u2 = new User();
//        u2.setAge(17);
//        u2.setName("hello imooc");
//        u2.setPassword("123456");
//        u2.setBirthday(new Date());
//
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//        userList.add(u1);
//        userList.add(u2);
//
//        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
//
//        String userListJson = redis.get("json:info:userlist");
//        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
//
//        return IMoocJSONResult.ok(userListBorn);
        return null;
    }

}