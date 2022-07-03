package com.atguigu.spring5.service.impl;

import com.atguigu.spring5.dao.BookDAO;
import com.atguigu.spring5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  // 注入DAO
  @Autowired
  private BookDAO bookDAO;


}
