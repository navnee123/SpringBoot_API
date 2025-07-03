package com.Spring.Web.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Web.Entities.Book;

@RestController
public class BookController {
	@GetMapping("/books")
	public Book getBooks() {
		Book b=new Book();
		b.setId(123);
		b.setTitle("java complete");
		b.setAuther("syd");
		return b;
	}

}
