package com.snipe.dto;
/**
 *  http请求返回的最外层对象
 *
 * */
public class Result<T> {

    /** 错误代码*/
    private Integer code;
    /** 提示信息*/
    private String message;
    /** 具体内容*/
    private T date;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}