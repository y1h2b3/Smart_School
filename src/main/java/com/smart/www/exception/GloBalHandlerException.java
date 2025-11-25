package com.smart.www.exception;

import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GloBalHandlerException {

    // 单独处理静态资源未找到异常,不打印日志
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseBody
    public void handleNoResourceFoundException(NoResourceFoundException e) {
        // 静默处理,不打印日志
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        System.out.println("全局异常触发...");
        e.printStackTrace();
        return Result.build(e.getMessage(), ResultCodeEnum.ERROR);
    }
}
