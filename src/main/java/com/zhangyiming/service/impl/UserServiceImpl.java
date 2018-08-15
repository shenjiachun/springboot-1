package com.zhangyiming.service.impl;

import com.zhangyiming.mapper.UserMapper;
import com.zhangyiming.mapper.UserMapperCustom;
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

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) throws Exception {

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> getAllUser(User user) {
        return userMapperCustom.getAllUser(user);
    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void deleteUser(String userId) {
//        userMapper.deleteByPrimaryKey(userId);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public User queryUserById(String userId) {
//
////        try {
////            Thread.sleep(6000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//        return userMapper.selectByPrimaryKey(userId);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public List<User> queryUserList(User user) {
//
//        try {
//            Thread.sleep(11000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//
//        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
////			criteria.andEqualTo("username", user.getUsername());
//            criteria.andLike("username", "%" + user.getUsername() + "%");
//        }
//
//        List<User> userList = userMapper.selectByExample(example);
//
//        return userList;
//    }
//
////    @Override
////    @Transactional(propagation = Propagation.SUPPORTS)
////    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
////        // 开始分页
////        PageHelper.startPage(page, pageSize);
////
////        Example example = new Example(SysUser.class);
////        Example.Criteria criteria = example.createCriteria();
////
////        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
////            criteria.andLike("nickname", "%" + user.getNickname() + "%");
////        }
////        example.orderBy("registTime").desc();
////        List<SysUser> userList = userMapper.selectByExample(example);
////
////        return userList;
////    }
//
////    @Override
////    @Transactional(propagation = Propagation.SUPPORTS)
////    public User queryUserByIdCustom(String userId) {
////
////        List<User> userList = userMapperCustom.queryUserSimplyInfoById(userId);
////
////        if (userList != null && !userList.isEmpty()) {
////            return (User)userList.get(0);
////        }
////
////        return null;
////    }
//
////    @Override
////    @Transactional(propagation = Propagation.REQUIRED)
////    public void saveUserTransactional(User user) {
////
////        userMapper.insert(user);
////
////        int a = 1 / 0;
////
////        user.setIsDelete(1);
////        userMapper.updateByPrimaryKeySelective(user);
////    }

}