package com.atguigu.spring5.jdbctemplate.service.impl;

import com.atguigu.spring5.jdbctemplate.entity.User;
import com.atguigu.spring5.jdbctemplate.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserServiceImplTest {

  private static ApplicationContext applicationContext;
  private static UserService userService;

  @BeforeAll
  public static void getContext() {
    applicationContext = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
    userService = (UserService) applicationContext.getBean("userServiceImpl");
  }

  @Test
  public void testJdbcTemplate() {
    User user = new User();
    user.setUserId(1);
    user.setUsername("java");
    user.setStatus("good");
    userService.addUser(user);
  }

  @Test
  public void testUpdate() {
    User user = new User();
    user.setUserId(10);
    user.setUsername("java");
    user.setStatus("good");
    userService.updateUser(user);
  }

  @Test
  public void testDelete() {
    userService.deleteUser(10);
  }

  @Test
  public void testGetCount() {
    System.out.println(userService.getUserCount());
  }

  @Test
  public void testGetUser() {
    System.out.println(userService.getUser(10));
  }

  @Test
  public void testGetUserList() {
    userService.getUserList().forEach(System.out::println);
  }

  @Test
  public void testBatchAddUser() {
    List<Object[]> batchArgs = new ArrayList<>();
    Object[] o1 = {2,"python","easy"};
    Object[] o2 = {3,"C","hard"};
    Object[] o3 = {4, "html", "normal"};
    batchArgs.add(o1);
    batchArgs.add(o2);
    batchArgs.add(o3);
    userService.batchAddUser(batchArgs);
  }
}