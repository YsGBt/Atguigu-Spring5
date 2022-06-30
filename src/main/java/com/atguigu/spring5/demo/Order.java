package com.atguigu.spring5.demo;

/**
 * 使用有参构造进行注入
 */
public class Order {

  private String orderName;
  private String address;

  public Order() {
    System.out.println("第一步 执行无参数构造创建bean实例");
  }

  // 有参构造
  public Order(String orderName, String address) {
    this.orderName = orderName;
    this.address = address;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
    System.out.println("第二部 调用set方法设置属性值");
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  // 创建执行的初始化的方法
  public void initMethod() {
    System.out.println("第三步 执行初始化方法");
  }

  // 创建执行的销毁方法
  public void destroyMethod() {
    System.out.println("第五步 执行销毁方法");
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderName='" + orderName + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
