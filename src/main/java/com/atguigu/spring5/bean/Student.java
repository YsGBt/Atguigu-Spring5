package com.atguigu.spring5.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
  // 1. 数组类型属性
  private String[] courses;

  // 2. List集合类型属性
  private List<String> list;

  // 3. Map集合类型属性
  private Map<String, String> map;

  // 4. Set集合类型属性
  private Set<String> set;

  // 5. 在集合里面设置对象类型值
  private List<Course> courseList;

  public String[] getCourses() {
    return courses;
  }

  public void setCourses(String[] courses) {
    this.courses = courses;
  }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  public Map<String, String> getMap() {
    return map;
  }

  public void setMap(Map<String, String> map) {
    this.map = map;
  }

  public Set<String> getSet() {
    return set;
  }

  public void setSet(Set<String> set) {
    this.set = set;
  }

  public List<Course> getCourseList() {
    return courseList;
  }

  public void setCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }

  @Override
  public String toString() {
    return "Student{" +
        "courses=" + Arrays.toString(courses) +
        ", list=" + list +
        ", map=" + map +
        ", set=" + set +
        ", courseList=" + courseList +
        '}';
  }
}
