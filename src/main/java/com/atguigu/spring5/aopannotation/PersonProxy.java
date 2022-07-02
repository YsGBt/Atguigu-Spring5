package com.atguigu.spring5.aopannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {

  @Before(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
  public void before() {
    System.out.println("person before...");
  }
}
