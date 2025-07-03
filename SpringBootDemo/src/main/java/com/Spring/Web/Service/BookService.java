package com.Spring.Web.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.Spring.Web.Entities.Book;
@Component
public class BookService {
	private static List<Book> l=new ArrayList<Book>();
	
//	static {
//		l.add(new Book(12,"java reference","xyZ"));
//		l.add(new Book(123,"java","ABC"));
//		l.add(new Book(124,"things in java","LMN"));
//	}
	
	//get all books
	public List<Book> getAllBooks(){
		return l;
	}
	
	public Book getBookById(int id) {
		Book b=null;
		try {
			b=l.stream().filter(e->e.getId()==id).findFirst().get();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return b;
	}
	
	public Book addBook(Book b) {
		l.add(b);
		return b;
	}

	public void deleteBook(int bid) {
		l= l.stream().filter(e->e.getId()!=bid).
		collect(Collectors.toList());
		
	}

	public void updateBook(Book book, int id) {
		
	l=l.stream().map(b->{
			if(b.getId()==id) 
			{
				b.setTitle(book.getTitle());
				b.setAuther(book.getAuther());
			}
			return b;
		}).collect(Collectors.toList());
		
	}

	

}
