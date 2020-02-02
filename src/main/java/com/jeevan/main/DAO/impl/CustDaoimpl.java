package com.jeevan.main.DAO.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.jeevan.main.DAO.CustDao;
import com.jeevan.main.model.Customer;
import com.jeevan.main.repository.CustRepository;

public class CustDaoimpl implements CustDao {

	@Autowired
	CustRepository repo;

	@Override
	public void addCustomer(Customer customer) {
		repo.save(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> cl = new ArrayList<Customer>();

		System.out.println("i am in getAllCustomers Dao");
		cl = (List<Customer>) repo.findAll();

		return cl;
	}

	public Customer getBalanceByid(Integer id) {
		System.out.println("in getBalanceByid DAO ");

		List<Customer> tl = new ArrayList<Customer>();
		tl = (List<Customer>) repo.findAll();

		Iterator<Customer> it = tl.iterator();

		while (it.hasNext()) {
			Customer c = (Customer) it.next();
			if (c.getAcno().equals(id)) {
				return c;

			}
		}

		return null;
	}

	public boolean verifyAccountByPin(Integer pin, Integer accNum) {
		System.out.println("I am in verifyAccountByPin DAO::: " + accNum + " " + pin);
		Customer c = new Customer();
		c = getBalanceByid(accNum);
		if (pin.equals(c.getPin())) {
			return true;
		} else
			return false;

	}

	public Integer withdraw(Integer accNum, Integer ammount) {
		Customer c = new Customer();
		c = getBalanceByid(accNum);
		Integer beforeAmmount = c.getBalance();
		if ((beforeAmmount - ammount) < 0)
			return 0;
		else {
			c.setBalance(beforeAmmount - ammount);
			repo.save(c);
			return (beforeAmmount - ammount);
		}

	}

	public void deposit(int accNum, int ammount) {
		Customer c = getBalanceByid(accNum);
		Integer beforeAmmount = c.getBalance();
		c.setBalance(beforeAmmount + ammount);
		repo.save(c);
	}

}
