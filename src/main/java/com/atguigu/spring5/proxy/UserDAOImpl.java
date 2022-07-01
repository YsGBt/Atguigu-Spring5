package com.atguigu.spring5.proxy;

public class UserDAOImpl implements UserDAO{

  @Override
  public int add(int a, int b) {
    return a + b;
  }

  @Override
  public String update(String id) {
    return id;
  }
}
