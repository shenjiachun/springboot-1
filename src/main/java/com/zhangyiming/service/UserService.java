package com.zhangyiming.service;

import com.zhangyiming.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\8 000822:14
 */
public interface UserService {

    void findUserByUserName(String username);

    void insertUser();

    void updateUser1() throws InterruptedException;

    void updateUser2() throws InterruptedException;

}