package com.nzyjfw.o2o.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ningyinqiang
 * @date 2020/3/5 11:12
 */
@Data
@AllArgsConstructor
public class Result {
    /**
     * 状态
     */
    private String status;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    public static Result success(String msg) {
        return new Result("success", msg, null);
    }

    public static Result success(String msg, Object data) {
        return new Result("success", msg, data);
    }

    public static Result error(String msg) {
        return new Result("error", msg, null);
    }

    public static Result error(String msg, Object data) {
        return new Result("error", msg, data);
    }
}