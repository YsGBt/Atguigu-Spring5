package com.atguigu.spring5.jdbctemplate.service.impl;

import com.atguigu.spring5.jdbctemplate.dao.AccountDAO;
import com.atguigu.spring5.jdbctemplate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountDAO accountDAO;

  @Override
  public void transferMoney() {
    // 第一步 开启事务

    // 第二步 进行业务操作
//    try {
      // lucy少100
      accountDAO.reduceMoney("lucy", 100);
      // 模拟异常
      int i = 10 / 0;
      // marry多100
      accountDAO.addMoney("marry", 100);

      // 第三步 没有发生一次，提交事务

//    } catch (Exception e) {
//      // 第四步 出现异常，事务回滚
//    }
  }
}
