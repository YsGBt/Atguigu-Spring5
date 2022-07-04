package com.atguigu.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
