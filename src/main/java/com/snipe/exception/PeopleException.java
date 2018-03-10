package com.snipe.exception;

import com.snipe.enums.ResultEnum;

/**
 *  spring框架只对你抛出的异常是RuntimeException才会对事务进行回滚
 *    由于Exception方法只能传入一个message而不能传入错误码，所以我们需要自定义一个异常类
 *
 * */
public class PeopleException extends RuntimeException{
    //错误代码
    private Integer code;
    /**
     *  @param resultEnum 传入对应的枚举信息
    */
    public PeopleException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
