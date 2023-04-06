package com.springbootmultipledatabase.db1.config;

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

import jakarta.persistence.spi.PersistenceProvider;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactoryBean",
		basePackages = {"com.springbootmultipledatabase.db1.repo"},
		transactionManagerRef = "transactionManager"
		)
	
public class db11config {
	
	@Value("${spring.db1.datasource.url}")
	private String url;
	
	@Value("${spring.db1.datasource.username}")
	private String username;
	
	@Value("${spring.db1.datasource.password}")
	private String password;
	
	@Bean
	@Primary
	public DataSource dataSource()
	{
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
		
	}
	
	@Bean(name = "entityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.springbootmultipledatabase.db1.beans");
		
		JpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
			
		Map<String, String> map=new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.hbm2ddl.auto", "update");
		
		bean.setJpaPropertyMap(map);
		return bean;
	}
	
	
	@Bean(name = "transactionManager")
	@Primary
	public PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
