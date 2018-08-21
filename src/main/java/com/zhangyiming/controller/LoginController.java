package com.zhangyiming.controller;

import com.zhangyiming.mapper.UserMapper;
import com.zhangyiming.pojo.IMoocJSONResult;
import com.zhangyiming.pojo.Role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public IMoocJSONResult guestlogin() {
        return new IMoocJSONResult("欢迎进入，您的身份是游客");
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public IMoocJSONResult userlogin() {
        return new IMoocJSONResult("您拥有用户权限，可以获得该接口的信息！");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public IMoocJSONResult adminlogin() {
        return new IMoocJSONResult("您拥有管理员权限，可以获得该接口的信息！");
    }

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public IMoocJSONResult notLogin() {
        return new IMoocJSONResult("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public IMoocJSONResult notRole() {
        return new IMoocJSONResult("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public IMoocJSONResult logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return new IMoocJSONResult("成功注销！");
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public IMoocJSONResult login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        Set<Role> roles = userMapper.findUserByUserName(username).getRoles();
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        for(Role role:roles){
            set.add(role.getRname());
        }
        if (set.contains("user")) {
            return new IMoocJSONResult("欢迎登陆");
        }
        if (set.contains("admin")) {
            return new IMoocJSONResult("欢迎来到管理员页面");
        }
        return new IMoocJSONResult("权限错误！");
    }
}