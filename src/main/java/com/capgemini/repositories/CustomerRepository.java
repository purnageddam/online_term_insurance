package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
