package com.zhangyiming.mapper;

import com.zhangyiming.pojo.User;
import com.zhangyiming.utils.MyMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends MyMapper<User> {

    @Select("select * from user where username = 'xyycici'")
    @Results(
            {
                    @Result(id=true,column="uid",property="uid"),
                    @Result(column="username",property="username"),
                    @Result(column="password",property="password")
            }
    )
    User findUserByUserName(String username);

}