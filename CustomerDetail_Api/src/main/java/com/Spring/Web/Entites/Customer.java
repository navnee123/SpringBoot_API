package com.Spring.Web.Entites;




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
@Table(name="Customer_Details")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cId;
	
	@Column(name="First_Name",length =50)
	private String firstName;
	
	@Column(name="Last_Name",length =50)
	private String lastName;
	
	private int age;
	@Column(name="Contact_no",length =50,unique = true)
	private int contactNo;
	
	@Column(name="Email_Id",length =50,unique = true)
	private String emailId;
	
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private Product product;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int cId, String firstName, String lastName, int age, int contactNo, String emailId, String city,
			Product product) {
		super();
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.city = city;
		this.product = product;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", contactNo=" + contactNo + ", emailId=" + emailId + ", city=" + city + ", product=" + product + "]";
	}
	
	
	
	
	
}
