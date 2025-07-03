package com.Spring.Web.DAO;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Web.Entities.Book;

public interface BookRepo extends CrudRepository<Book,Integer>{
  public Book findById(int id);
}
