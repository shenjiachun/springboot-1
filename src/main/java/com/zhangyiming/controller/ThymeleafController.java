package com.zhangyiming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\7 000721:33
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        return "security";
    }
//
    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }
//
//    @RequestMapping("test")
//    public String test(ModelMap map) {
//
//        User u = new User();
//        u.setUsername("superadmin");
//        u.setPassword("123465");
//
//        map.addAttribute("user", u);
//
//        User u1 = new User();
//        u1.setUsername("imooc");
//        u1.setPassword("123456");
//
//        User u2 = new User();
//        u2.setUsername("LeeCX");
//        u2.setPassword("123456");
//
//        List<User> userList = new ArrayList<>();
//        userList.add(u);
//        userList.add(u1);
//        userList.add(u2);
//
//        map.addAttribute("userList", userList);
//
//        return "thymeleaf/test";
//    }
//
//    @PostMapping("postform")
//    public String postform(User u) {
//
//        System.out.println("姓名：" + u.getUsername());
//        return "redirect:/th/test";
//    }
//
//    @RequestMapping("showerror")
//    public String showerror(User u) {
//
//        int a = 1 / 0;
//
//        return "redirect:/th/test";
//    }
}