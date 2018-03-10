package com.snipe.enums;
/**
 *  通过枚举将code和message 都维护在一个地方
 *      这样的好处就是  统一维护
 *      只修改一处，其他的代码都不需要更改
 * */
public enum ResultEnum {

    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学吧"),
    MIDDLE_SCHOOL(101,"你可能还在上初中吧"),
    ;
    //错误码
    private Integer code;
    //错误信息
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
