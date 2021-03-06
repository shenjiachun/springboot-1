package com.zhangyiming.service.impl;

import com.zhangyiming.dto.Goods;
import com.zhangyiming.mapper.GoodsMapper;
import com.zhangyiming.service.GoodsService;
import com.zhangyiming.service.RoleService;
import com.zhangyiming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    private static final String path = "D:/图片/";

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Override
    public List<Goods> get(Goods goods) {
        List<Goods> goodsList = goodsMapper.get(goods);
        File file;
        FileInputStream is = null;
        try {
            for (Goods aGoodsList : goodsList) {
                file = new File(path + aGoodsList.getPaths());
                is = new FileInputStream(file);
                int length = is.available(); // 得到文件大小
                byte[] bytes = new byte[length];
                is.read(bytes); // 读数据
                aGoodsList.setBytes(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return goodsList;
    }

    @Override
    @Transactional( rollbackFor = Throwable.class)
    public void test1() {
        userService.insertUser();
        roleService.insertRoleException();
    }

    @Override
    @Transactional( rollbackFor = Throwable.class)
    public void test2() {
        userService.insertUser();
        try {
            roleService.insertRoleException();
        }catch (Throwable throwable){
            System.out.println("方法回滚");
        }
    }

    @Override
    @Transactional( rollbackFor = Throwable.class)
    public void test3() {
        userService.insertUser();
        roleService.insertRole();
        throw new RuntimeException("测试");
    }

}