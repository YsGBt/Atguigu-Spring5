package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.bean.Course;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class MyBeanTest {

  @Test
  public void testMyBean() {
    ApplicationContext context = new ClassPathXmlApplicationContext("factoryBean.xml");
    Course myBean = context.getBean("myBean", Course.class);
    System.out.println(myBean);
  }
}