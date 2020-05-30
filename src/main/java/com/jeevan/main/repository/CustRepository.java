package com.jeevan.main.repository;


import org.springframework.data.repository.CrudRepository;

import com.jeevan.main.model.Customer;

public interface CustRepository extends CrudRepository<Customer, Integer> {   //or extend JPARepository provides g the persistence context and deleting of records in batch

}
