package com.guocz.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author guocz
 * @date 2022/7/25 11:01
 */
@AllArgsConstructor
@Data
public class BaseResult<T> implements Serializable {

    private int code;

    private Boolean success;

    private T data;

    private String msg;

    public static BaseResult success() {
        return new BaseResult(1, true, null, null);
    }

    public static BaseResult success(Object data) {
        return new BaseResult(1, true, data, null);
    }

    public static BaseResult fail() {
        return new BaseResult(0, false, null, null);
    }

    public static BaseResult fail(String msg) {
        return new BaseResult(0, false, null, msg);
    }

    public static BaseResult fail(Integer code, String msg) {
        return new BaseResult(code, false, null, msg);
    }
}
