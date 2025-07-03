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

import com.Spring.Web.Entites.Customer;
import com.Spring.Web.Service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cs;
	
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getDetails(){
		List<Customer> cus = cs.getAllDetail();
		if(cus.size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(cus));
		}
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id")int id) {
		Customer cus=cs.getCusById(id);
		if(cus==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 return ResponseEntity.of(Optional.of(cus));
		
	}
	
	
	@PostMapping("/Customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
		try {
			Customer cs=this.cs.addCustomer(c);
			return ResponseEntity.of(Optional.of(cs));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/Customer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") int id){
		try {
			   this.cs.deleteCustomer(id);
			   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
    @PutMapping("/Customer/{id}")
    public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer cs,@PathVariable("id")int id){
    	 try {
		         this.cs.updateById(cs,id);
			return ResponseEntity.ok().body(cs);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    	
    }
	

}
