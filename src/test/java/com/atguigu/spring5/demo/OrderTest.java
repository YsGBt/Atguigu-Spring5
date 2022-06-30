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

  @Test
  public void testBeanLifeCycle() {
    ApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle.xml");

    Order order = context.getBean("order", Order.class);
    System.out.println("第四步 获取创建bean实例对象");
    System.out.println(order);
    ((ClassPathXmlApplicationContext) context).close();
  }

}