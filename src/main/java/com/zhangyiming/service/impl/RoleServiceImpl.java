package com.zhangyiming.service.impl;

import com.zhangyiming.mapper.RoleMapper;
import com.zhangyiming.pojo.Role;
import com.zhangyiming.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertRole() {
        roleMapper.insert(new Role("李四"));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insertRoleException() {
        roleMapper.insert(new Role("李四"));
        throw new RuntimeException("测试");
    }

}