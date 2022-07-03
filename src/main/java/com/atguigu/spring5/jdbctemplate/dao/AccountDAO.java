package com.atguigu.spring5.jdbctemplate.dao;

public interface AccountDAO {

  void addMoney(String username, Integer amount);

  void reduceMoney(String username, Integer amount);
}
