package com.atguigu.spring5.jdbctemplate.service.impl;

import com.atguigu.spring5.config.SpringConfig;
import com.atguigu.spring5.jdbctemplate.entity.Account;
import com.atguigu.spring5.jdbctemplate.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = SpringConfig.class)
@SpringJUnitConfig(classes = SpringConfig.class)
class AccountServiceImplTest {

//  private static ApplicationContext applicationContext;
  @Autowired
  private AccountService accountService;

  @BeforeAll
  public static void getContext() {
//    applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//    accountService = (AccountService) applicationContext.getBean("accountServiceImpl");
  }

  @Test
  public void testTransfer() {
    accountService.transferMoney();
  }

  // 函数式风格创建对象，交给spring进行管理
  @Test
  public void testGenericApplicationContext() {
    // 1. 创建GenericApplicationContext对象
    GenericApplicationContext context  = new GenericApplicationContext();
    // 2. 调用context的方法对象注册
    context.refresh();
    context.registerBean("account1", Account.class, () -> new Account());
    // 3. 获取在spring注册的对象
    Account account = (Account) context.getBean("account1");
    System.out.println(account);
  }
}