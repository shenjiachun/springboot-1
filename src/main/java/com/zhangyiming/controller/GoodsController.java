package com.zhangyiming.controller;

import com.zhangyiming.dto.Goods;
import com.zhangyiming.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/show")
    public String show(Goods goods){
        return "thymeleaf/goods";
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public Object get(Goods goods){
        return goodsService.get(goods);
    }



}