package com.Spring.Web.Dao;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Web.Entites.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer>{
	public Customer findById(int id);
	public Customer findByName(String name);
	public Customer findByEmailId(String emailId);

}
