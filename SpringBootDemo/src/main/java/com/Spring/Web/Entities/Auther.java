package com.Spring.Web.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Auther {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int auther_id;
	
	@Column(name="First_name")
	private String firstName;
	
	@Column(name="Last_name")
	private String lastName;
	
	private String language;
	
	@OneToOne(mappedBy = "auther",fetch = FetchType.EAGER)
	@JsonBackReference
	private Book book;
	
	public int getAuther_id() {
		return auther_id;
	}
	public void setAuther_id(int auther_id) {
		this.auther_id = auther_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
