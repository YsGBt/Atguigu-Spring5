package com.atguigu.spring5.jdbctemplate.service.impl;

import com.atguigu.spring5.jdbctemplate.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class AccountServiceImplTest {

  private static ApplicationContext applicationContext;
  private static AccountService accountService;

  @BeforeAll
  public static void getContext() {
    applicationContext = new ClassPathXmlApplicationContext("transaction.xml");
    accountService = (AccountService) applicationContext.getBean("accountServiceImpl");
  }

  @Test
  public void testTransfer() {
    accountService.transferMoney();
  }
}