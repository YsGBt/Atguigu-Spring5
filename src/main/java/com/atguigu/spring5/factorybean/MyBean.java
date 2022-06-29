package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.bean.Course;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course> {

  // 定义返回bean
  // -> Course myBean = context.getBean("myBean", Course.class);
  @Override
  public Course getObject() throws Exception {
    Course course = new Course();
    course.setName("java");
    return course;
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }
}
