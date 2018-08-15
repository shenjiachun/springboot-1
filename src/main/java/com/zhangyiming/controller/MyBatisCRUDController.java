package com.zhangyiming.controller;

import com.zhangyiming.pojo.IMoocJSONResult;
import com.zhangyiming.pojo.User;
import com.zhangyiming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\14 001415:55
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() throws Exception {

        User user = new User("张壹鸣","1","003958");

        userService.saveUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/update")
    public IMoocJSONResult update() throws Exception {

        User user = new User(6,"张壹鸣11","1","003958");

        userService.updateUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/getAllUser")
    public IMoocJSONResult getAllUser(User user) throws Exception {
        return IMoocJSONResult.ok(userService.getAllUser(user));
    }

}