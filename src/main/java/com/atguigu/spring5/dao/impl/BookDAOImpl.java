package com.atguigu.spring5.dao.impl;

import com.atguigu.spring5.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {

  // 注入JdbcTemplate
  @Autowired
  private JdbcTemplate jdbcTemplate;
}
