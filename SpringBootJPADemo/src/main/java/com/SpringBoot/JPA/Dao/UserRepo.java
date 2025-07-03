package com.SpringBoot.JPA.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SpringBoot.JPA.Entities.User;

public interface UserRepo extends CrudRepository<User, Integer>{ 
	public List<User> findByName(String Name);
	public List<User> findByNameAndCity(String name,String city);

}
