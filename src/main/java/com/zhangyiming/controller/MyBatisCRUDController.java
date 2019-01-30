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
        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/update")
    public IMoocJSONResult update() throws Exception {
        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/getAllUser")
    public IMoocJSONResult getAllUser(User user,String username) throws Exception {
        return new IMoocJSONResult(userService.findUserByUserName(username));
    }

}