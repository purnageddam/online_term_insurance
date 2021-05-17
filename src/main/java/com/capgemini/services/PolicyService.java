package com.capgemini.services;

import java.util.List;

import com.capgemini.entities.Policy;

public interface PolicyService{

	Policy savePolicy(Policy p);

	Policy findById(int id);

	List<Policy> findAll();

	Policy updatePolicy(int id, Policy p);

	Policy deletePolicy(int id);
	

}
