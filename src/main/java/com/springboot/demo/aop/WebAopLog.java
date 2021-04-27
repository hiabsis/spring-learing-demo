package com.springboot.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author      : cyw
 * @date        : created in  下午3:54 2021/4/26
 * @description :
 * @modified by :
 * @Version : $
 */
@Aspect
@Component
@Slf4j
public class WebAopLog {
   @Pointcut("execution(public * com.springboot.demo.controller.*.*(..))")
   public void webLog(){}
   @Pointcut("@annotation(com.springboot.demo.aop.annotation.LogAction)")
   public void logAction(){}
   @Before("webLog()")
   public void doBefore(JoinPoint joinPoint){
      // 接收到请求，记录请求内容
      log.info("WebLogAspect.doBefore()");
      ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      HttpServletRequest request = attributes.getRequest();

      // 记录下请求内容
      System.out.println("============");
      log.info("URL : " + request.getRequestURL().toString());
      log.info("HTTP_METHOD : " + request.getMethod());
      log.info("IP : " + request.getRemoteAddr());
      log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
      log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
      //获取所有参数方法一：
      Enumeration<String> enu = request.getParameterNames();
      while (enu.hasMoreElements()) {
         String paraName = (String) enu.nextElement();
         System.out.println(paraName + ": " + request.getParameter(paraName));
      }
   }


   @After("logAction()")
   public void doAfter(JoinPoint joinPoint){
      // 接收到请求，记录请求内容
      log.info("ActionLog");
      log.info("ActionLog");
      log.info("ActionLog");

   }


}
