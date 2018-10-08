package com.zhangyiming.controller;

import com.zhangyiming.mapper.UserMapper;
import com.zhangyiming.pojo.IMoocJSONResult;
import com.zhangyiming.pojo.Resource;
import com.zhangyiming.pojo.User;
import com.zhangyiming.timer.rabbitmq.Sender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\7 000715:19
 */
@RestController
public class HellowController {

    @Autowired
    private Resource resource;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/hello")
    public Object hello(String name){
        return name + " hello";
//        User user = userMapper.findUserByUserName("xyycici");
//        return new IMoocJSONResult(user);
    }

    @RequestMapping(value = "/getResource")
    public Object getResource(){
        Resource re = new Resource();
        BeanUtils.copyProperties(resource,re);

        return IMoocJSONResult.ok(re);
    }

    @RequestMapping(value = "/sendMsg")
    public void sendMsg(){
        //Sender.sendMsg("hello world!");
    }
}