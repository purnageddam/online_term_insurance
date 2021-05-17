package com.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	

}
