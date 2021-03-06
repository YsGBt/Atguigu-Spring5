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
                  - 创建类，定义属性，创建属性对应的有参数的构造方法
                  - 在Spring配置文件中进行配置
                    可以用参数名称(name)或者参数位置(index)
                    <bean id="order" class="com.atguigu.spring5.demo.Order">
                      <constructor-arg name="orderName" value="电脑"></constructor-arg>
                      <constructor-arg index="1" value="China"></constructor-arg>
                    </bean>

               3) 第三种注入方式: p名称空间注入 (写法简化，本质还是constructor方法注入)
                  - 使用p名称空间注入，可以简化基于xml配置方式
                  - 第一步 添加p名称空间在配置文件中
                    xmlns:p="http://www.springframework.org/schema/p"
                  - 第二部 进行属性注入，在bean标签里面进行操作
                    <bean id="book2" class="com.atguigu.spring5.demo.Book" p:bookName="易筋经" p:author="达摩"></bean>

               4) xml注入其他类型属性
                  a. 字面量
                     - null值
                       <!-- 设置null值 -->
                       <property name="author">
                         <null></null>
                       </property>

                     - 属性值包含特殊符号
                       1. 把<>进行转义 &lt; &gt;
                       2. 把带特殊符号内容写到 CDATA
                       <property name="author">
                         <value><![CDATA[<<达摩>>]]></value>
                       </property>

                  b. 注入属性
                     - 外部bean
                       1. 创建两个类service和dao类
                       2. 在service调用dao里的方法
                       3. 在Spring配置文件中进行配置
                       <!-- service和dao对象创建 -->
                       <bean id="userService" class="com.atguigu.spring5.service.impl.UserServiceImpl">
                         <!--
                           注入userDAO对象
                           name: 类里面的属性名称
                           ref: 创建userDAO对象bean标签id值
                          -->
                         <property name="userDAO" ref="userDAO"></property>
                       </bean>

                       <bean id="userDAO" class="com.atguigu.spring5.dao.impl.UserDAOImpl"></bean>

                     - 内部bean
                       1. 一对多关系: 部门和员工 1:n
                       2. 在实体类之间表示一对多关系
                       3. 在Spring文件中进行配置
                       <bean id="employee" class="com.atguigu.spring5.bean.Employee">
                         <!-- 设置两个普通属性 -->
                         <property name="name" value="Lucy"></property>
                         <property name="gender" value="female"></property>
                         <!-- 设置对象类型属性 -->
                         <property name="department">
                           <bean id="department" class="com.atguigu.spring5.bean.Department">
                             <property name="name" value="安保部"></property>
                           </bean>
                         </property>
                       </bean>

                     - 级联赋值 (需要在Employee类中生成Department的get方法)
                       <bean id="employee2" class="com.atguigu.spring5.bean.Employee">
                         <!-- 设置两个普通属性 -->
                         <property name="name" value="Lucy"></property>
                         <property name="gender" value="female"></property>
                         <!-- 级联赋值 -->
                         <property name="department.name" value="技术部"></property>
                       </bean>
                       <bean id="department2" class="com.atguigu.spring5.bean.Department">
                         <property name="name" value="财务部"></property>
                       </bean>

                  c. 注入集合 (在beanStudent.xml)
                     - 注入数组类型属性
                     - 注入List集合类型属性
                     - 注入Map集合类型属性
                     - 注入Set集合类型属性
                     - 把集合注入部分提取出来
                       1. 在Spring配置文件中引入名称空间util
                       <beans xmlns="http://www.springframework.org/schema/beans"
                         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                         xmlns:util="http://www.springframework.org/schema/util"
                         xsi:schemaLocation="
                               http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                               http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">
                       2. 使用util标签完成List集合注入提取

       2. 基于注解方式实现

  5) FactoryBean
     - Spring有两种类型Bean，一种普通Bean，另外一种工厂Bean (FactoryBean)
     - 普通Bean: 在配置文件中定义bean类型就是返回类型
     - 工厂Bean: 在配置文件定义bean类型可以和返回类型不一样
       1. 创建类，让这个类作为工厂bean，实现接口FactoryBean
       2. 实现接口里面的方法，在实现的方法中定义返回的bean类型
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

  6) Bean作用域
     - 在Spring里面，设置创建bean实例是单实例还是多实例
     - 默认情况下，bean是单实例对象 (多次调用getBean获得的对象是一个)
     - 设置 单实例 / 多实例 (通过设置 scope):
       scope属性值:
          1. 默认值: singleton -> 表示是单实例对象
          2.        prototype -> 表示是多实例对象
          3.        request   -> 创建对象放入request中
          4.        session   -> 创建对象放入session中
     - singleton和prototype区别
       1. singleton 单实例，prototype 多实例
       2. singleton -> 加载spring配置文件时就会创建单实例对象
       3. prototype -> 不是在加载spring配置文件时创对象，而是在调用getBean方法时才创建多实例对象

  7) Bean的生命周期 (对象从创建到销毁的过程 在beanLifeCycle.xml & OrderTest.java)
     - 生命周期
       1. 通过构造器创建bean实例(无参数构造器)
       2. 为bean的属性设置值和对其他bean引用(调用set方法)
       3.0 把bean实例传递bean后置处理器的方法(后置处理器 postProcessBeforeInitialization)
       3.1 调用bean的初始化的方法(需要进行配置)
       3.2 把bean实例传递bean后置处理器的方法(后置处理器 postProcessAfterInitialization)
       4. bean可以使用了(对象获取到了)
       5. 当容器关闭时，调用bean的销毁方法(需要进行配置销毁的方法)

     - 后置处理器 BeanPostProcessor (在MyBeanPost.java)

  8) Bean自动装配
     - 根据指定装配规则(属性名称或者属性类型)，Spring自动将匹配的属性值进行注入
         bean标签属性autowire，配置自动装配
         autowire属性常用两个值:
           byName 根据属性名称注入，property name要和bean id一样
           byType 根据属性值注入，相同类型的bean不能定义多个

  9）引入外部属性文件
     - 创建外部properties文件
     - 把外部properties属性文件引入到spring配置文件中
       *引入context名称空间
       <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>

  10) Bean管理(注解方式)
      - 创建对象
        1. @Component
        2. @Service
        3. @Controller
        4. @Repository

      - 基于注解方式实现对象创建 (在com.atguigu.spring5.annotation)
        1. 引入依赖 (spring-aop)
        2. 开启组件扫描
           - 如果扫描多个包，多个包使用逗号隔开
           - 或者扫描包的上层目录
           <context:component-scan base-package="com.atguigu.spring5.annotation"></context:component-scan>
        3. 创建类，在类上面创建添加对象注解 (在com.atguigu.spring5.annotation.UserService)
        4. 开启组件扫描的细节配置 (use-default-filters)

      - 基于注解方式实现属性注入 (在com.atguigu.spring5.annotation)
        1. @AutoWired -> 根据属性类型进行自动装配
        2. @Qualifier -> 根据属性名称进行注入,需要跟@AutoWired一起使用
        3. @Resource -> 可以根据类型注入，也可以根据名称注入，在javax包下，不建议使用
        4. @Value -> 注入普通类型属性

      - 完全注解开发 (在com.atguigu.spring5.annotation.config)
        1. 创建配置类，替代xml配置文件

2. AOP
   1) 什么是AOP (Aspect Oriented Programming)
      - 面向切面编程: 降低耦合
      - 通俗描述: 在不通过修改源代码的方式，在猪肝功能里添加新的功能
   2) AOP底层原理
      - AOP底层使用动态代理
        a. 有两种情况的动态代理
           - 有接口情况，使用JDK动态代理
             创建接口实现类代理对象，增强类的方法
             Proxy.newProxyInstance(ClassLoader loader, Class<?> interfaces, InvocationHandler h);
             第一个参数: 类加载器
             第二个参数: 增强方法所在的类，这个类实现的接口，支持多个接口
             第三个参数: 实现这个接口InvocationHandler，创建代理对象，写增强的方法

           - 没有接口情况，使用CGLIB动态代理
             创建子类的代理对象，增强类的方法
   3) AOP术语
      - 连接点: 类里面哪些方法可以被增强，这些方法就被称为连接点
      - 切入点: 实际被真正增强的方法，被称为切入点
      - 通知(增强)
        a. 实际增强的逻辑部分称为通知(增强)
        b. 通知有多种类型: 前置通知、后置通知、环绕通知、异常通知(catch)、最终通知(finally)
      - 切面: 把通知应用到切入点的过程
   4) AOP操作
      - Spring框架中一般基于AspectJ实现AOP操作
        a. AspectJ: 不是Spring组成部分，独立AOP框架，一般把AspectJ和Spring框架一起使用，进行AOP操作
      - 基于AspectJ实现AOP操作
        a. 基于xml配置文件实现
        b. 基于注解方式实现
      - 切入点表达式
        a. 切入点表达式作用: 知道对哪个类里面的哪个方法进行增强
        b. 语法结构:
           execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
      - 进行通知的配置:
        a. 在Spring配置文件中，开启注解扫描
        b. 使用注解创建User和UserProxy对象
        c. 在增强类上面添加注解@Aspect
           // 增强类
           @Component
           @Aspect // 生成代理对象
           public class UserProxy {}
        d. 在Spring配置文件中开启生成代理对象
           <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
      - 配置不同类型的通知 (在UserProxy.java)
        a. 在增强类里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置
           @Before(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
      - 抽取相同的切入点
        @Pointcut(value = "execution(* com.atguigu.spring5.aopannotation.User.add(..))")
        public void commonPoint() {
        }

        @Before(value = "commonPoint()")
        public void ...
      - 有多个增强类对同一个方法进行增强，设置增强类优先级
        a. 在增强类上面添加注解 @Order(数字类型值)，数字类型值越小优先级越高
      - 完全使用注解开发
        @Configuration
        @ComponentScan(basePackages = {"com.atguigu"})
        @EnableAspectJAutoProxy(proxyTargetClass = true)
        public class ConfigAop {
        }

3. JdbcTemplate
  1) 什么是JdbcTemplate
     - Spring框架对JDBC进行封装，使用JdbcTemplate可以方便的实现对数据库的操作
  2) 创建数据库连接池
  3) 配置JdbcTemplate对象，注入DataSource
     <!-- JdbcTemplate对象 -->
     <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
       <!-- 注入dataSource -->
       <property name="dataSource" ref="dataSource"></property>
     </bean>
  4) 创建Service类，创建DAO类，在DAO注入JdbcTemplate对象 (在com.atguigu.spring5.jdbctemplate)
  5) JdbcTemplate实现批量操作
     - batchUpdate(String sql, List<Object[]> batchArgs);

4. 事务 (在com.atguigu.spring5.jdbctemplate)
   1) 事务是数据库操作最基本单元，逻辑上一组操作，要么都成功，如果有一个失败所有操作都失败
   2) 事务四个特性 (ACID)
      - 原子性 Atomicity
      - 一致性 Consistency
      - 隔离性 Isolation
      - 持久性 Durability
   3) 事务操作
      - 事务添加到JavaEE三层结构里面Service层 (业务逻辑层)
      - 在Spring进行事务管理操作
        a. 两种方式: 编程式事务管理和声明式事务管理 (一般使用声明式事务管理)
      - 声明式事务管理
        a. 基于注解方式 (使用)
           1. 在Spring配置文件中配置事务管理器
              <!-- 创建事务管理器 -->
              <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                <!-- 注入dataSource -->
                <property name="dataSource" ref="dataSource"></property>
              </bean>
           2. 在Spring配置文件中开启事务注解
              1) 在Spring配置文件中引入名称空间 tx
              2) 开启事务的注解
                 <!-- 开启事务注解 -->
                 <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
              3) 在service类上面 (获取service类里面方法上面)添加事务注解
                 - @Transactional，这个注解可以添加到类上面，也可以添加到方法上面
                 - 如果添加到类上面，这个类里面所有的方法都添加事务
                 - 如果添加到方法上面，那只为这个方法添加事务

        b. 基于xml配置文件方式
           1. 在spring配置文件中机进行配置
              - 配置事务管理器
              - 配置通知
              - 配置切入点和切面

      - 在Spring进行声明式事务管理，底层使用AOP
      - Spring事务管理API:
        a. 提供一个接口，代表事务管理器，这个接口针对不同的框架提供不同的实现类
           PlatformTransactionManager
      - 声明式事务管理参数配置 @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
        a. propagation: 事务传播行为 (当一个事务方法被另一个事务方法调用时，这个事务方法如何进行)
           - REQUIRED: 如果有事务在运行，当前的方法就在这个事务内运行，否则，就启动一个新的事务，并在自己的事务内运行
           - REQUIRED_NEW: 当前的方法必须启动新事物，并在它自己的事务内运行，如果有事务正在运行，应该将它挂起
           - SUPPORTS: 如果有事务在运行，当前的方法就在这个事务内运行，否则它可以不运行在事务中

        b. isolation: 事务隔离级别
           - 事务有特性称为隔离性，多事务操作之间不会产生影响。不考虑隔离性会产生很多的问题。
           - 有三个读的问题: 脏读、不可重复读、幻读
             1. 脏读: 一个未提交事务读取到另一个未提交事务的数据
             2. 不可重复读: 一个未提交事务读取到了另一个已提交事务修改的数据
             3. 幻读: 一个未提交事务读取到了另一个已提交事务添加的数据
           - 通过设置事务隔离级别，解决读问题
             1. Read Uncommitted (读未提交)
             2. Read Committed (读已提交)
             3. Repeatable Ream (可重复读)
             4. Serializable (串行化)

        c. timeout: 超时时间
           - 事务需要在一定的时间内进行提交，如果不提交则进行回滚
           - 默认值 -1 (不限时)，设置时间以秒为单位

        d. readOnly: 是否只读
           - 读: 查询操作， 写: 添加修改删除操作
           - readOnly 默认值 false， 表示可以查询，也可以添加修改删除
           - 设置readOnly为true，表示只能查询

        e. rollbackFor: 回滚
           - 设置查询哪些异常进行事务回滚

        f. noRollbackFor: 不回滚
           - 设置出现哪些异常不进行事务回滚
   4) 完全注解开发
      @Configuration // 作为配置类，替代xml配置文件
      @ComponentScan(basePackages = {"com.atguigu.spring5.annotation","com.atguigu.spring5.jdbctemplate"})
      @EnableAspectJAutoProxy(proxyTargetClass = true) // 开启生成代理对象
      @EnableTransactionManagement // 开启事务
      public class SpringConfig {

        // 创建数据库连接池
        @Bean
        public DruidDataSource getDruidDataSource() {
          DruidDataSource druidDataSource = new DruidDataSource();
          druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
          druidDataSource.setUrl("jdbc:mysql://localhost:3306/atguigu_spring?rewriteBatchedStatements=true&enabledTLSProtocols=TLSv1.2&useSSL=false");
          druidDataSource.setUsername("javaConnection");
          druidDataSource.setPassword("tztlx13GBT");
          return druidDataSource;
        }

        // 创建JdbcTemplate对象
        @Bean
        public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
          // 到ioc容器中根据类型找到datasource
          JdbcTemplate jdbcTemplate = new JdbcTemplate();
          jdbcTemplate.setDataSource(dataSource);
          return jdbcTemplate;
        }

        // 创建事务管理器
        @Bean
        public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
          DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
          dataSourceTransactionManager.setDataSource(dataSource);
          return dataSourceTransactionManager;
        }
      }

5. Spring5新功能
   1) Spring5 框架自带了通用的日志封装
      - Spring5 已经移除了Log4jConfigListener，官方建议使用Log4j2 (log4j2.xml)
   2) Spring5 框架核心容器支持 @Nullable 注解
      - @Nullable 注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以为空，参数值可以为空
      - @NonNull 注解可以标注在方法、字段、参数之上，表示对应的值不能为空；
      - 用处:
        - 它清楚地说明了这个方法接受空值，而且如果你重写该方法，你也应该接受空值
        - @Nullable表明该参数可能为null。一个很好使用例子就是谷歌Guice。在这个轻量级依赖注入框架中，你可以说明这个依赖项可能是空的。如果你试图在没有注解的情况下传递空值，这个框架就不会执行它的工作。
   3) Spring5 核心容器支持函数风格GenericApplicationContext
   4) Spring5 支持整合 JUint5
      - 整合 JUnit4
        a. 引入Spring相关针对测试的依赖 (spring-test)
        b. 创建测试类，使用注解方式完成
           @RunWith(SpringJUnit4ClassRunner.class) // 指定单元测试版本 JUnit4
           @ContextConfiguration("classpath:transaction.xml") // 加载配置文件

      - 整合 JUnit5
        a. 引入Spring相关针对测试的依赖 (spring-test), 引入JUnit5依赖
        b. 创建测试类，使用注解方式完成
           @ExtendWith(SpringExtension.class)
           @ContextConfiguration(classes = SpringConfig.class)
           或使用一个复合注解替代上面两个注解完成整合
           @SpringJUnitConfig(classes = SpringConfig.class)
   5) SpringWebFlux








