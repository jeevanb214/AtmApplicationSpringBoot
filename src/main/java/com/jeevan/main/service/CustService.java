package com.jeevan.main.service;

import java.util.List;

import com.jeevan.main.model.Customer;

public interface CustService {
	
	public void addCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();

	public Customer getBalanceByid(Integer id);

	public boolean verifyAccountByPin(Integer pin, Integer accNum);

	public Integer withdraw(Integer accNum, Integer ammount);

	public void deposit(int acno, int amount);


}
