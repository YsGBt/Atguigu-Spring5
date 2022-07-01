package com.atguigu.spring5.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

  public static void main(String[] args) {
    // 创建接口实现类的代理对象
    UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(UserDAOImpl.class.getClassLoader(), UserDAOImpl.class.getInterfaces(),
        new UserDAOHandler(new UserDAOImpl()));
    System.out.println("userDAO.add(1,2) = " + userDAO.add(1, 2));
    System.out.println(userDAO.update("update"));
  }
}

// 创建代理对象代码
class UserDAOHandler implements InvocationHandler {

  private Object target;

  // 传递代理对象
  public UserDAOHandler(Object target) {
    this.target = target;
  }

  // 增强的逻辑
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 方法之前
    System.out.println("方法之前执行... " + method.getName() + ": 传递参数 " + Arrays.toString(args));

    // 被增强的方法执行
    Object res = method.invoke(target, args);

    //方法之后
    System.out.println("方法之后执行..." + target);
    return res;
  }
}

