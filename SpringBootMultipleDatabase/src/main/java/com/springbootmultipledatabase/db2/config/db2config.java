package com.springbootmultipledatabase.db2.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondManagerFactoryBean",
		basePackages = {"com.springbootmultipledatabase.db2.repo"},
		transactionManagerRef = "transactionManagers"
		)

public class db2config {
	
	
	@Value("${spring.db2.datasource.url}")
	private String url;
	
	@Value("${spring.db2.datasource.username}")
	private String username;
	
	@Value("${spring.db2.datasource.password}")
	private String password;
	
	@Bean
	@Primary
	public DataSource dataSource1()
	{
		
		DriverManagerDataSource dataSource1=new DriverManagerDataSource();
		dataSource1.setUrl(url);
		dataSource1.setUsername(username);
		dataSource1.setPassword(password);
		return dataSource1;
		
	}
	
	@Bean(name = "secondManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource1());
		bean.setPackagesToScan("com.springbootmultipledatabase.db2.beans");
		
		JpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
			
		Map<String, String> map=new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.hbm2ddl.auto", "update");
		
		bean.setJpaPropertyMap(map);
		return bean;
	}
	
	
	@Bean(name = "transactionManagers")
	@Primary
	public PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


}
