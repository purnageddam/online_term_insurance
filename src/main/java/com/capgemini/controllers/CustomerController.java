package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Customer;
import com.capgemini.services.CustomerService;
import com.capgemini.services.CustomerServiceImpl;

@RestController
@RequestMapping("/api/login/")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/v1/")
	public ResponseEntity<Boolean> createCustomerv1(@RequestBody Customer customer){
		
		customerServiceImpl.createCustomer(customer);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable int id){
		Customer customer = customerServiceImpl.findById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@GetMapping("/all/")
	public List<Customer> findAll(){
		return customerServiceImpl.findAll();
	}
	
	@PutMapping("/updatelogin/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer c){
		Customer customer = customerServiceImpl.updateCustomer(id, c);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
