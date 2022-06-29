package com.atguigu.spring5.bean;

public class Employee {

  private String name;
  private String gender;
  // 员工属于某一个部门，使用对象形式表示
  private Department department;

  public void setName(String name) {
    this.name = name;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Department getDepartment() {
    return department;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", gender='" + gender + '\'' +
        ", department=" + department +
        '}';
  }
}
