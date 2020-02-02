package com.jeevan.main.repository;


import org.springframework.data.repository.CrudRepository;

import com.jeevan.main.model.Customer;

public interface CustRepository extends CrudRepository<Customer, Integer> {

}
