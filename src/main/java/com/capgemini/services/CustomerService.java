package com.capgemini.services;

import com.capgemini.entities.Customer;

public interface CustomerService {

	boolean createCustomer(Customer customer);
	
	 Customer findById(int id);

}
