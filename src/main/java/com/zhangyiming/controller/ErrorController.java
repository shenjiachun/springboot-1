package com.zhangyiming.controller;

import com.zhangyiming.pojo.IMoocJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\8 000820:32
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {

        int a = 1 / 0;

        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public IMoocJSONResult getAjaxerror() {

        int a = 1 / 0;

        return IMoocJSONResult.ok();
    }
}