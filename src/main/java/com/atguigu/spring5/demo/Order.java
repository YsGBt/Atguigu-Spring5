package com.atguigu.spring5.demo;

/**
 * 使用有参构造进行注入
 */
public class Order {

  private String orderName;
  private String address;

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
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderName='" + orderName + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
