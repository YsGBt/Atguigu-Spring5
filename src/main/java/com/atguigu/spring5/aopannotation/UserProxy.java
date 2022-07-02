package com.atguigu.spring5.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

// 增强类
@Component
@Aspect // 生成代理对象
@Order(3)
public class UserProxy {

  // 相同的切入点抽取
  @Pointcut(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
  public void commonPoint() {
  }

  // 前置通知
  // @Before注解表示作为前置通知
  @Before(value = "commonPoint()")
  public void before() {
    System.out.println("before...");
  }

  // 后置通知 (返回通知)
  @AfterReturning(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
  public void afterReturning() {
    System.out.println("after returning...");
  }

  // 环绕通知
  @Around(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
  public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("环绕之前...");
    // 被增强的方法执行
    proceedingJoinPoint.proceed();
    System.out.println("环绕之后...");
  }

  // 异常通知
  @AfterThrowing(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
  public void afterThrowing() {
    System.out.println("after throwing...");
  }

  // 最终通知
  @After(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
  public void after() {
    System.out.println("after...");
  }

}
