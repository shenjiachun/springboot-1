package com.zhangyiming.service;

import com.zhangyiming.pojo.User;

import java.util.List;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\8 000822:14
 */
public interface UserService {

      void saveUser(User user) throws Exception;

      void updateUser(User user);

      List<User> getAllUser(User user);
//
//    public void deleteUser(String userId);
//
//    public User queryUserById(String userId);
//
//    public List<User> queryUserList(User user);

//    public List<User> queryUserListPaged(User user, Integer page, Integer pageSize);
//
//    public User queryUserByIdCustom(String userId);
//
//    public void saveUserTransactional(User user);
}