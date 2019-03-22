package com.zhangyiming.service.impl;

import com.zhangyiming.mapper.RoleMapper;
import com.zhangyiming.mapper.UserMapper;
import com.zhangyiming.pojo.User;
import com.zhangyiming.service.RoleService;
import com.zhangyiming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\8 000822:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public void findUserByUserName(String username) {
        insertUser();
//        return userMapper.findUserByUserName(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertUser(){
        userMapper.insert(new User("张三","1"));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void updateUser1() throws InterruptedException {
        userMapper.updateByPrimaryKey(new User(1,"hlhdidi","1234"));
        Thread.sleep(3000);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void updateUser2() throws InterruptedException {
        userMapper.updateByPrimaryKey(new User(1,"hlhdidi","12345"));
    }

}