package com.jeevan.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acno")
	private Integer acno;//IF we declare acNo then in the spring jpa concept it will be parsed to ac_No and search in the table which may cases the some exceptions.
	
	@Column
	private String name;

	@Column
	private Integer age;
	
	@Column
	private String city;
	
	@Column
	private Integer balance;
	
	@Column
	private Integer pin;

	public Integer getAcno() {
		return acno;
	}

	public void setAcNo(Integer acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}
	
	


}
