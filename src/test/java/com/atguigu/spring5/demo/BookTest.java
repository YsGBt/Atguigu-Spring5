package com.atguigu.spring5.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BookTest {

  @Test
  public void testBook() {
    // 1. 加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

    // 2. 获取配置创建的对象
    Book book = context.getBean("book", Book.class);

    System.out.println(book);
  }

}