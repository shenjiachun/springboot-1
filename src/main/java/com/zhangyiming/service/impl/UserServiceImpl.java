package com.zhangyiming.service.impl;

import com.zhangyiming.mapper.UserMapper;
import com.zhangyiming.pojo.User;
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

    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

}