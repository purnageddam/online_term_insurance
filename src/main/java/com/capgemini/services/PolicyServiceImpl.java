package com.capgemini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Customer;
import com.capgemini.entities.Policy;
import com.capgemini.exceptions.CustomerException;
import com.capgemini.repositories.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Policy savePolicy(Policy p) {
		// TODO Auto-generated method stub
		return policyRepository.save(p);
		
	}

	@Override
	public Policy findById(int id) {
		// TODO Auto-generated method stub
		if(!policyRepository.existsById(id)) {
			throw new CustomerException("Customer Not Found");
		}
		Policy p =policyRepository.findById(id).get();
		return p;
		
	}

	@Override
	public List<Policy> findAll() {
		// TODO Auto-generated method stub
		return policyRepository.findAll();
	}

	@Override
	public Policy updatePolicy(int id, Policy p) {
		// TODO Auto-generated method stub
	      Policy policy = policyRepository.findById(id).get();
		if(policy != null) {
			policy.setPolicyName(p.getPolicyName());
			
			
			policyRepository.save(policy);
		}
		return policyRepository.save(policy);
		
	}

	@Override
	public Policy deletePolicy(int id) {
		// TODO Auto-generated method stub
		Policy policy = policyRepository.findById(id).get();
		 policyRepository.deleteById(id);
		return policy;
		
	}
	

}
