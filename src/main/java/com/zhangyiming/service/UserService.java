package com.zhangyiming.service;

import com.zhangyiming.pojo.User;

import java.util.List;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\8 000822:14
 */
public interface UserService {

    User findUserByUserName(String username);

}