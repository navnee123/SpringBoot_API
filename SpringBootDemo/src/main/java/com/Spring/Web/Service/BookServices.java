package com.Spring.Web.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.Web.DAO.BookRepo;
import com.Spring.Web.Entities.Book;
@Component
public class BookServices {
    
	@Autowired
	private BookRepo bk;
	
	
	//get all books
	public List<Book> getAllBooks(){
		List<Book> lt=(List<Book>)this.bk.findAll();
		return lt;
	}
	
	public Book getBookById(int id) {
		Book b=null;
		try {
			b=this.bk.findById(id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return b;
	}
	
	public Book addBook(Book b) {
		Book res=bk.save(b);
		return res;
	}

	public void deleteBook(int bid) {
		bk.deleteById(bid);
		
	}

	public void updateBook(Book book, int id) {
		
     book.setId(id);
     bk.save(book);
		
	}

	

}
