package com.machinetest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.machinetest.dao.UserDao;
import com.machinetest.dao.UserDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.machinetest")
public class WebConfig {
	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/");
		ivr.setSuffix(".jsp");
		return ivr;

	}
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/machinetest");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl(getDataSource());
	}
}
