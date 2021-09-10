package com.demo.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

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
    @Around("afterCallMethod()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.err.println("Starting method at: " + LocalDate.now());
        Object value = null;


        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.err.println("Throwing exception at: " + LocalDate.now());
            throwable.printStackTrace();
        }

        System.err.println("Finishing method at: " + LocalDate.now() + " Return: " + value);
        return value;
    }


}
