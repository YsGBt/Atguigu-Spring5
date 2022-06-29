package com.atguigu.spring5.service.impl;

import com.atguigu.spring5.dao.UserDAO;
import com.atguigu.spring5.service.UserService;

public class UserServiceImpl implements UserService {

  // 创建UserDAO类型属性，生成set方法
  private UserDAO userDAO;

  @Override
  public void addUser() {
    System.out.println("service add....");
    userDAO.addUser();
  }

  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }
}
