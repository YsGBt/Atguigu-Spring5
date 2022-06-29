package com.atguigu.spring5.dao.impl;

import com.atguigu.spring5.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

  @Override
  public void addUser() {
    System.out.println("user dao add...");
  }
}
