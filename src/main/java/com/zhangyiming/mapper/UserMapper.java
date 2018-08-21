package com.zhangyiming.mapper;

import com.zhangyiming.pojo.User;
import com.zhangyiming.utils.MyMapper;

public interface UserMapper extends MyMapper<User> {

    User findUserByUserName(String username);

}