package com.Spring.Web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.Web.Dao.CustomerRepo;
import com.Spring.Web.Entites.Customer;

@Component
public class CustomerService {
	@Autowired
	private CustomerRepo cr;

	public List<Customer> getAllDetail() {
	      List<Customer> cus=  (List<Customer>) this.cr.findAll();
		return cus;
	}

	public Customer getCusById(int id) {
		Customer cu=null;
		
		try {
			cu=this.cr.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cu;
	}

	public Customer addCustomer(Customer c) {
		Customer cs=cr.save(c);
		return cs;
	}

	public void deleteCustomer(int id) {
		this.cr.deleteById(id);
		
	}

	public void updateById(Customer cs, int id) {
		cs.setcId(id);
		cr.save(cs);
	}

	

	
	
	

}
