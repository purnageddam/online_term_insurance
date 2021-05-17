package com.capgemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Customer;
import com.capgemini.exceptions.CustomerException;
import com.capgemini.repositories.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public boolean createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		return true;
	}

	public Customer findById(int id) {
		// TODO Auto-generated method stub
		if(!customerRepository.existsById(id)) {
			throw new CustomerException("Customer Not Found");
		}
		Customer c =customerRepository.findById(id).get();
		return c;
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	
	}

	/*public Customer updateCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).get();
		if(customer != null) {
			customer.setUsername(customer.getUsername());
			customer.setPassword(customer.getPassword());
			
			customerRepository.save(customer);
		}
		return customerRepository.save(customer);
	}*/

	public Customer updateCustomer(int id, Customer c) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).get();
		if(customer != null) {
			customer.setUsername(c.getUsername());
			customer.setPassword(c.getPassword());
			
			customerRepository.save(customer);
		}
		return customerRepository.save(customer);
		
	}

}
