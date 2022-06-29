package com.atguigu.spring5.bean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class EmployeeTest {

  @Test
  public void testEmployee() {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
    Employee employee = context.getBean("employee2", Employee.class);
    System.out.println(employee);
  }
}