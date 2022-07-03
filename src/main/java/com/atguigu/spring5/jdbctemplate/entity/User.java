package com.atguigu.spring5.jdbctemplate.entity;

public class User {

  private Integer userId;
  private String username;
  private String status;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User{" +
        "userId='" + userId + '\'' +
        ", username='" + username + '\'' +
        ", status='" + status + '\'' +
        '}';
  }
}
