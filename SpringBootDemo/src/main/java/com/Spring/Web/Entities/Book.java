package com.Spring.Web.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	@Column(name="book_title")
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private Auther auther;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

   

	public Book(int id, String title, Auther auther) {
		super();
		this.id = id;
		this.title = title;
		this.auther = auther;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public Auther getAuther() {
		return auther;
	}



	public void setAuther(Auther auther) {
		this.auther = auther;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", auther=" + auther + "]";
	}

   
	

	
	

}
