package com.atguigu.spring5.jdbctemplate.dao.impl;

import com.atguigu.spring5.jdbctemplate.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;


  @Override
  public void addMoney(String username, Integer amount) {
    String sql = "update t_account set money=money+? where username=?";
    jdbcTemplate.update(sql, amount, username);
  }

  @Override
  public void reduceMoney(String username, Integer amount) {
    addMoney(username, -amount);
  }
}
