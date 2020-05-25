package com.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lishuhan
 * @Description:Http请求监听
 * @Date Create in 11:402018-5-9
 * @Modified By:
 */
@Aspect
@Component
public class HttpAspect {
    private  static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.api.action..*.*(..))")
    public void mainAction(){
    }
    @Before("mainAction()")
    public void dobefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("mainAction()")
    public void doAfter(){
        logger.info("访问结束");
    }

    @AfterReturning(returning = "object",pointcut = "mainAction()")
    public void doAfterReturn(Object object){
        //返回数据
        logger.info("response={}",object.toString());
    }
}
