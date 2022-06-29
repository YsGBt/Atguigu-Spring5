package com.atguigu.spring5.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class OrderTest {

  @Test
  public void testOrder() {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

    Order order = context.getBean("order", Order.class);

    System.out.println(order);
  }

}