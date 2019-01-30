package com.zhangyiming;

import com.zhangyiming.mapper.RoleMapper;
import com.zhangyiming.mapper.UserMapper;
import com.zhangyiming.pojo.Role;
import com.zhangyiming.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SprintBootTest.class)
@SpringBootApplication
@ActiveProfiles("sharding")
public class SprintBootTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test(){
        // t_user有进行分库，且id为1时路由到afei_user_1数据库
        User authUser = userMapper.selectByPrimaryKey(1L);
        Assert.assertEquals((long)authUser.getUid(), 1L);
        System.out.println(authUser);

        // t_user有进行分库，且id为2时路由到afei_user_0数据库
        authUser = userMapper.selectByPrimaryKey(2L);
        Assert.assertEquals((long)authUser.getUid(), 2L);
        System.out.println(authUser);

        // t_config没有分库分表，走默认数据源，即afei_test数据源
        Role role = roleMapper.selectByPrimaryKey(1L);
        Assert.assertEquals((long)role.getRid(), 1L);
        System.out.println(role);
    }

}