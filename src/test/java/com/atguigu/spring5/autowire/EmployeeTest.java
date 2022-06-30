package com.atguigu.spring5.autowire;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {
  @Test
  public void testAutowire() {
    ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");

    Employee employee = context.getBean("employee", Employee.class);

    System.out.println(employee);
  }


}