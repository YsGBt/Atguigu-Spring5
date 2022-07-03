package com.atguigu.spring5.jdbctemplate.service;

import com.atguigu.spring5.jdbctemplate.entity.User;
import java.util.List;

public interface UserService {

  void addUser(User user);

  void updateUser(User user);

  void deleteUser(Integer userId);

  int getUserCount();

  User getUser(Integer userId);

  List<User> getUserList();

  void batchAddUser(List<Object[]> users);
}
