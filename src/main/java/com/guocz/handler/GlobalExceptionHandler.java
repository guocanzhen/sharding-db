package com.guocz.handler;

import com.guocz.result.BaseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author guocz
 * @date 2022/7/25 14:15
 */
@Log4j2
@RestControllerAdvice(basePackages = "com.guocz.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleValidException(MethodArgumentNotValidException e) {
        log.error("入参异常：{}，详情：{}", e.getBindingResult().getFieldError().getField(), e.getBindingResult().getFieldError().getDefaultMessage());
        return BaseResult.fail(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public BaseResult handleSqlException(DuplicateKeyException e) {
        log.error("数据重复：{}", e.getMessage());
        return BaseResult.fail("数据已存在");
    }

    @ExceptionHandler(Exception.class)
    public BaseResult handleException(Exception e) {
        log.error("系统异常：{}", e.getMessage());
        return BaseResult.fail("系统异常，请联系管理员处理");
    }
}
