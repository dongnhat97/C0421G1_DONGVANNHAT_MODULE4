package com.demo.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
   static int count =0;
    @Pointcut("within(com.demo.controller.BookController*)")
    public void afterCallMethod() {
  }
    @After("afterCallMethod()")
    public void afterCallMethod(JoinPoint joinPoint)  {
        count++;
        System.out.println("Số lần người ghé thăm là : "+count+"join : ");

    }
}
