package com.zhangyiming.bean;

import com.zhangyiming.utils.SpringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {

    @Resource(name = "car")
    private Car car;

    @RequestMapping("/beandemo/test")
    public void test(){
        Car car1 = SpringUtil.getBean(Car.class);
        int a = 1;
    }

}