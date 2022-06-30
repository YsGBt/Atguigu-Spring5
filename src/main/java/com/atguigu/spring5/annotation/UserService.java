package com.atguigu.spring5.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// 在注解里面value属性值可以省略不写，
// 默认值是类名称，首字母小写: userService
@Service // <bean id="userService" class="com. ... .UserService"></bean>
public class UserService {

  // 不需要添加set方法
  @Autowired // 不添加@Qualifier的话默认根据类型进行注入
  @Qualifier(value = "userDaoImpl1") //根据名称进行注入
  private UserDAO userDAO;

  // 最好不要用@Resource
//  @Resource // 根据类型注入
//  @Resource(name = "userDaoImpl1") // 根据名称注入
//  private UserDAO userDAO;

  @Value(value = "abc")
  private String name;


  public void add() {
    System.out.println("service add...");
    System.out.println(name);
    userDAO.add();
  }
}
