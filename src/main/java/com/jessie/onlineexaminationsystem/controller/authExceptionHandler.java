package com.jessie.onlineexaminationsystem.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import com.jessie.onlineexaminationsystem.domain.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class authExceptionHandler {

    @ExceptionHandler(value = SaTokenException.class)
    public Result LoginErr(SaTokenException e) {
        if (e instanceof NotLoginException)
            return Result.error("没有登录或登录已经失效！");
        else {
            return Result.error(e.getMessage());
        }
    }
}
