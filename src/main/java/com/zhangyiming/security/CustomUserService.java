package com.zhangyiming.security;

//import com.zhangyiming.mapper.UserMapper;
//import com.zhangyiming.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class CustomUserService implements UserDetailsService {
//
//    private static UserMapper userMapper;
//
//    @Autowired
//    private void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userMapper.findUserByUserName(s);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword().trim()));
//        return user;
//    }
//
//}