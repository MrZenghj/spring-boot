package com.snipe.utils;

import com.snipe.dto.Result;
/**
 *  抽取重复代码
 *      返回信息格式
 * */
public class ResultUtil {

    /**成功
     * @param  obj 返回的数信息
     * */
    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setDate(obj); //
        return result;
    }
    public static Result success(){  //重载  成功也有可能不返回数据信息
        return success(null);
    }

    /**
     * 失败
     *  @param code 失败时代码编号
     *  @param message 失败信息
     * */
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
