package com.atguigu.spring5.annotation;

import com.atguigu.spring5.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserServiceTest {

  @Test
  public void testAnnotation() {
    ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");

    UserService userService = context.getBean("userService", UserService.class);

    System.out.println(userService);
    userService.add();
  }

  @Test
  public void testAnnotation2() {
    // 加载配置类
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    UserService userService = context.getBean("userService", UserService.class);

    System.out.println(userService);
    userService.add();
  }
}