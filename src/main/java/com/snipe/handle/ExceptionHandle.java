package com.snipe.handle;

import com.snipe.dto.Result;
import com.snipe.exception.PeopleException;
import com.snipe.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  对异常进行捕获
 *      service层向上抛出异常，controller层也抛出异常 最后又这个类捕获
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    //处理 Exception 抛出的异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleException(Exception e){
        //捕获自定义的异常
        if(e instanceof PeopleException){
            PeopleException peopleException = (PeopleException)e;
            return ResultUtil.error(peopleException.getCode(),peopleException.getMessage());
        }else {
            logger.error("【系统异常】:{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
