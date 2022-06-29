package com.atguigu.spring5.bean;

public class Department {

  private String name;

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Department{" +
        "name='" + name + '\'' +
        '}';
  }
}
