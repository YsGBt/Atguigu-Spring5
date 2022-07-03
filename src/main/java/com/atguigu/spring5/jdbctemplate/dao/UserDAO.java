package com.atguigu.spring5.jdbctemplate.dao;

import com.atguigu.spring5.jdbctemplate.entity.User;
import java.util.List;

public interface UserDAO {

  void add(User user);

  void update(User user);

  void delete(Integer userId);

  int getCount();

  User getUser(Integer userId);

  List<User> getUserList();

  void batchAddUser(List<Object[]> users);
}
