package com.atguigu.spring5.jdbctemplate.service.impl;

import com.atguigu.spring5.jdbctemplate.dao.UserDAO;
import com.atguigu.spring5.jdbctemplate.entity.User;
import com.atguigu.spring5.jdbctemplate.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;


  @Override
  public void addUser(User user) {
    userDAO.add(user);
  }

  @Override
  public void updateUser(User user) {
    userDAO.update(user);
  }

  @Override
  public void deleteUser(Integer userId) {
    userDAO.delete(userId);
  }

  @Override
  public int getUserCount() {
    return userDAO.getCount();
  }

  @Override
  public User getUser(Integer userId) {
    return userDAO.getUser(userId);
  }

  @Override
  public List<User> getUserList() {
    return userDAO.getUserList();
  }

  @Override
  public void batchAddUser(List<Object[]> users) {
    userDAO.batchAddUser(users);
  }
}
