package com.SpringMain.API;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jeevan.main.controller.CustController;
import com.jeevan.main.repository.CustRepository;

@SpringBootTest
class AtmAppSprinBootApplicationTests {

	@Autowired
	CustRepository repo;

	@BeforeEach
	public CustController each() {
		return null;
		
	}

	@Test
	void contextLoads() {
		System.out.println("hhhhh");
	}

}
