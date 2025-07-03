package com.Spring.Web.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Web.Entities.Book;
import com.Spring.Web.Service.BookServices;

@RestController
public class BookController2 {
	@Autowired
	private BookServices bs;
	
//	@GetMapping("/book")
//	public List<Book> getBooks() {
//	 
//		return this.bs.getAllBooks();
//	}
	
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getBooks() {
	 
		List<Book> l=bs.getAllBooks();
		if(l.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		return ResponseEntity.of(Optional.of(l));
		return ResponseEntity.status(HttpStatus.CREATED).body(l);
	}
	
//	@GetMapping("/book/{id}")
//	public Book getBook(@PathVariable("id") int id) {
//		return bs.getBookById(id);
//	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		Book b= bs.getBookById(id);
		if(b==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 return ResponseEntity.of(Optional.of(b));
	}
	
//	@PostMapping("/book")
//	public Book addBook(@RequestBody Book b) {
//		Book bk=this.bs.addBook(b);
//		System.out.println(b);
//		return bk;
//		}
	
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book b) {
		Book bk=null;
				try {
					bk=bs.addBook(b);
                   System.out.println(b);
                   return ResponseEntity.of(Optional.of(b));
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
		}
	
	
//	@DeleteMapping("/book/{id}")
//	public void deleteBook(@PathVariable("id") int id) {
//		this.bs.deleteBook(id);
//	}
	
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try {
			this.bs.deleteBook(id);
			//return ResponseEntity.ok().build();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
//	@PutMapping("/book/{id}")
//	public ResponseEntity<Book> updateBook(@RequestBody Book bo,@PathVariable("id") int id) {
//			this.bs.updateBook(bo,id);
//			return bo;
//		}

	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book bo,@PathVariable("id") int id) {
		try {
			this.bs.updateBook(bo,id);
			return ResponseEntity.ok().body(bo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
