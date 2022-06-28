package com.atguigu.spring5;

import com.atguigu.spring5.demo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

  @Test
  public void add() {
    // 1. 加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

    // 2. 获取配置创建的对象
    User user = context.getBean("user", User.class);

    System.out.println(user);
    user.add();
  }
}