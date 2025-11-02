package com.smart.www.exception;

import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloBalHandlerException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        System.out.println("全局异常触发...");
        e.printStackTrace();
        return Result.build(e.getMessage(), ResultCodeEnum.ERROR);
    }
}
