package com.atguigu.spring5.annotation;

import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImpl1")
public class UserDAO {

  public void add() {
    System.out.println("dao add...");
  }
}
