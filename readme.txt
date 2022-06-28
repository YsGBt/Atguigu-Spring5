1. IOC
  1) 什么是IOC
     - 控制反转，把对象创建和对象之间的调用过程，交给Spring进行管理
     - 使用IOC的目的: 为了降低耦合度

  2) IOC底层原理
     - xml解析、工厂模式、反射

  3) IOC接口
     - IOC思想基于IOC容器完成，IOC容器底层就是对象工厂
     - Spring提供IOC容器实现两种方式: (两个接口)
       1. BeanFactory: IOC容器基本实现，是Spring内部使用的接口，一般不提供开发人员进行使用
                       * 加载配置文件时不会创建对象，在获取对象(使用)时才去创建文件
       2. ApplicationContext: BeanFactory接口的子接口，提供更多更强大的功能，一般由开发人员进行使用
                              * 加载配置文件时就会把在配置文件对象进行创建
       3. ApplicationContext接口的实现类:
          - FileSystemXmlApplicationContext
          - ClassPathXmlApplicationContext

  4) IOC操作Bean管理
     - 什么是Bean管理(Bean管理的两个操作)
       1. Spring创建对象
       2. Spring注入属性
     - Bean管理操作由两种方式
       1. 基于xml配置文件方式实现
          a. 在Spring配置文件中，使用bean标签，标签里面添加对应的属性，就可以实现对象创建
             <bean id="user" class="com.atguigu.spring5.demo.User"></bean>
          b. 在bean标签由很多属性，介绍常用的属性:
             * id属性: 唯一标识
             * class属性: 类全路径(包类路径)
          c. 创建对象时候，默认也是执行无参数构造方法
          d. 基于xml方式注入属性
             - DI: 依赖注入，就是注入属性
               1) 第一种注入方式: 使用set方法进行注入
                  - 在Spring配置文件配置对象创建，配置属性注入
                    name: 类里面属性名称
                    value: 向属性注入的值
                    <bean id="book" class="com.atguigu.spring5.demo.Book">
                      <property name="bookName" value="易筋经"></property>
                      <property name="author" value="达摩"></property>
                    </bean>

               2) 第二种注入方式: 使用有参数的构造进行注入

       2. 基于注解方式实现
