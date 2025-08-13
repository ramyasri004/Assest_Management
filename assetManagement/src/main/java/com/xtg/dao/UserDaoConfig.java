package com.xtg.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.xtg")
public class UserDaoConfig {
	@Bean
	public DataSource setDataSource() {
		DriverManagerDataSource datasource = null;
		try {
			datasource = new DriverManagerDataSource();
			datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			datasource.setUrl("jdbc:mysql://localhost:3306/assetmanagement");
			datasource.setUsername("root");
			datasource.setPassword("root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datasource;
	}
	@Bean
	public JdbcTemplate setJdbcTemplate() {
		JdbcTemplate jdbcTemplate = null;
		try {
			jdbcTemplate = new JdbcTemplate(setDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdbcTemplate;
	}
}

