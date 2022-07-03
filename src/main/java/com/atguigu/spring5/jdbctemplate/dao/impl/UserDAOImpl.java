package com.atguigu.spring5.jdbctemplate.dao.impl;

import com.atguigu.spring5.jdbctemplate.dao.UserDAO;
import com.atguigu.spring5.jdbctemplate.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

  @Autowired
  public JdbcTemplate jdbcTemplate;

  @Override
  public void add(User user) {
    jdbcTemplate.update("insert into t_user values (?,?,?)", user.getUserId(), user.getUsername(),
        user.getStatus());
  }

  @Override
  public void update(User user) {
    jdbcTemplate.update("update t_user set username=?,ustatus=? where user_id=?",
        user.getUsername(), user.getStatus(), user.getUserId());
  }

  @Override
  public void delete(Integer userId) {
    jdbcTemplate.update("delete from t_user where user_id=?", userId);
  }

  @Override
  public int getCount() {
    String sql = "select count(*) from t_user";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    return count;
  }

  @Override
  public User getUser(Integer userId) {
    String sql = "select user_id, username, ustatus status from t_user where user_id=?";
    User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userId);
    return user;
  }

  @Override
  public List<User> getUserList() {
    String sql = "select user_id, username, ustatus status from t_user";
    List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    return userList;
  }

  @Override
  public void batchAddUser(List<Object[]> users) {
    String sql = "insert into t_user values (?,?,?)";
    jdbcTemplate.batchUpdate(sql, users);
  }
}
