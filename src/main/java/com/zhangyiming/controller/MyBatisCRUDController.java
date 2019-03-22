package com.zhangyiming.controller;

import com.zhangyiming.pojo.IMoocJSONResult;
import com.zhangyiming.pojo.User;
import com.zhangyiming.service.GoodsService;
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
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() throws Exception {
        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/update")
    public IMoocJSONResult update() throws Exception {
        return IMoocJSONResult.ok("保存成功");
    }

//    @RequestMapping("/getAllUser")
//    public IMoocJSONResult getAllUser(User user,String username) throws Exception {
//        return new IMoocJSONResult(userService.findUserByUserName(username));
//    }

    @RequestMapping("/test1")
    public void test1(){
        goodsService.test1();
    }

    @RequestMapping("/test2")
    public void test2(){
        goodsService.test2();
    }

    @RequestMapping("/test3")
    public void test3(){
        goodsService.test3();
    }

    @RequestMapping("/test4")
    public void test4() throws InterruptedException {
        userService.updateUser1();
    }

    @RequestMapping("/test5")
    public void test5() throws InterruptedException {
        userService.updateUser2();
    }

}