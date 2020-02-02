package com.jeevan.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeevan.main.DAO.CustDao;
import com.jeevan.main.model.Customer;
import com.jeevan.main.service.CustService;

public class CustServiceImpl implements CustService {

	@Autowired
	CustDao cd; 
	
	@Override
	public void addCustomer(Customer customer) {
		cd.addCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> cl = new ArrayList<Customer>();

		cl = cd.getAllCustomers();
		return cl;
	}

	public Customer getBalanceByid(Integer id) {

		Customer c = cd.getBalanceByid(id);
		return c;
	}
	
	public boolean verifyAccountByPin(Integer pin,Integer accNum)
	{
		
		return cd.verifyAccountByPin(pin,accNum);
	}

	public Integer withdraw(Integer accNum, Integer ammount) {
		
		return cd.withdraw(accNum, ammount);
	}
	
	public void deposit(int acno, int amount) {		
		cd.deposit(acno, amount);
		
	}

}
