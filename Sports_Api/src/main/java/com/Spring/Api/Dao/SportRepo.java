package com.Spring.Api.Dao;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Api.Entities.Sport;

public interface SportRepo extends CrudRepository<Sport,Integer>{
	public Sport findById(int id);

}
