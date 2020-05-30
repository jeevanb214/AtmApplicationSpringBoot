package com.jeevan.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeevan.main.DAO.impl.CustDaoimpl;
import com.jeevan.main.service.impl.CustServiceImpl;

@SpringBootApplication
public class AtmSpringBootApplication /* extends SpringBootServletInitializer */ {

	
	private static final Logger LOGGER=LoggerFactory.getLogger(AtmSpringBootApplication.class);											
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(AtmSpringBootApplication.class); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(AtmSpringBootApplication.class, args);
			LOGGER.error(" LOGGER error");
			LOGGER.warn(" LOGGER warn");
			LOGGER.info(" LOGGER info");
			LOGGER.debug(" LOGGER debug");

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
