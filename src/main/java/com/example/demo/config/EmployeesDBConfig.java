package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.example.demo.dao.employees", sqlSessionFactoryRef="employeesDBSessionFactory")
public class EmployeesDBConfig
{
	// DataSource 객체 생성
	@Primary
	@Bean(name = "employeesDBDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.employees-db")
	DataSource employeesDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	
	// SqlSessionFactory
	@Primary
	@Bean(name = "employeesDBSessionFactory")
	SqlSessionFactory employeesSessionFactory
	(@Qualifier("employeesDBDataSource") DataSource dataSource)
	throws Exception
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		sqlSessionFactoryBean.setMapperLocations
		(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/employees/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	
	// 트랙잭션 메니저
	@Primary
	@Bean(name = "employeesDBTransactionManager")
	DataSourceTransactionManager employeesTransactionManager
	(@Qualifier("employeesDBDataSource") DataSource dataSource)
	throws Exception
	{
		return new DataSourceTransactionManager(dataSource);
	}
	
}
