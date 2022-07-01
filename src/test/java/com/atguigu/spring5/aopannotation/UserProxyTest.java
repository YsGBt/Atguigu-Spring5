package com.atguigu.spring5.aopannotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserProxyTest {

  @Test
  public void testAOP() {
    ApplicationContext context = new ClassPathXmlApplicationContext("aopannotation.xml");
    User user = context.getBean("user", User.class);
    user.add();
  }
}