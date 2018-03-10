package com.snipe.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *  AOP控制
 * */
@Aspect
@Component
public class HttpAspect {
    //日志
    private final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //切面
    @Pointcut("execution(public * com.snipe.controller.PeopleController.*(..))")
    public void log(){}

    /**
     *  进入方法前要做的事
     *      例如：获取ip、url、请求方法、类方法、方法参数
     *      @param joinPoint 加入点 可获取方法中的东西
     * */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取httpServletRequest
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        logger.info("进入........doBefore()");
        //获取url
        logger.info("url:{}",request.getRequestURI());
        //获取ip
        logger.info("id:{}",request.getRemoteHost());
        //获取method
        logger.info("method:{}",request.getMethod());
        //类方法
        logger.info("className:{}",joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        //方法参数
        logger.info("agr:{}",joinPoint.getArgs());

    }

    /**
     *  离开方法后要做的事
     * */
    @After("log()")
    public void doAfter(){
        logger.info("进入.........doAfter()");
    }

    /**
     *  返回方法中的对象
     *  @param obj 返回的对象
     *
     * */
    @AfterReturning(returning = "obj",pointcut = "log()")
    public void doAfterReturning(Object obj){
        logger.info("obj:{}",obj.toString());
    }
}
