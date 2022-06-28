package com.atguigu.spring5.demo;

/**
 * 演示使用set方法进行注入属性
 */
public class Book {

  // 创建属性
  private String bookName;
  private String author;

  public Book() {
  }

  // 有参构造注入
  public Book(String bookName) {
    this.bookName = bookName;
  }

  public Book(String bookName, String author) {
    this.bookName = bookName;
    this.author = author;
  }

  public String getBookName() {
    return bookName;
  }

  // set方法注入
  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "Book{" +
        "bookName='" + bookName + '\'' +
        ", author='" + author + '\'' +
        '}';
  }
}
