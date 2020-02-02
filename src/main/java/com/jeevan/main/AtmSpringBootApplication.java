package com.jeevan.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.jeevan.main.DAO.CustDao;
import com.jeevan.main.DAO.impl.CustDaoimpl;
import com.jeevan.main.model.Customer;
import com.jeevan.main.service.CustService;
import com.jeevan.main.service.impl.CustServiceImpl;

@SpringBootApplication
public class AtmSpringBootApplication /* extends SpringBootServletInitializer */ {

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(AtmSpringBootApplication.class); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(AtmSpringBootApplication.class, args);
	}

	@Bean
	public CustServiceImpl getCustService() {
		return new CustServiceImpl();
	}

	@Bean
	public CustDaoimpl getCustDao() {
		return new CustDaoimpl();
	}

}
