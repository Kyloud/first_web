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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.example.demo.dao.account", sqlSessionFactoryRef="accountDBSessionFactory")
public class AccountDBConfig
{
	// DataSource 객체 생성
	@Bean(name = "accountDBDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.account-db")
	DataSource policyDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	// SqlSessionFactory
	@Bean(name = "accountDBSessionFactory")
	SqlSessionFactory policySessionFactory
	(@Qualifier("accountDBDataSource") DataSource dataSource)
	throws Exception
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		sqlSessionFactoryBean.setMapperLocations
		(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/account/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	// 트랙잭션 메니저
	@Bean(name = "accountDBTransactionManager")
	DataSourceTransactionManager policyTransactionManager
	(@Qualifier("accountDBDataSource") DataSource dataSource)
	throws Exception
	{
		return new DataSourceTransactionManager(dataSource);
	}
	
}