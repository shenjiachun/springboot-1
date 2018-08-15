package com.zhangyiming.exception;

import com.zhangyiming.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\4\8 000820:42
 */
@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception {

        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }
}