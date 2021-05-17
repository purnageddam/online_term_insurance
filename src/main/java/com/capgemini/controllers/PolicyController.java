package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Policy;
import com.capgemini.services.PolicyService;

@RestController
@RequestMapping("/api/policylist/")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/policy")
	public Policy createPolicy(@RequestBody Policy p) {
		return policyService.savePolicy(p);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Policy> findById(@PathVariable int id){
		Policy policy = policyService.findById(id);
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}
	
	@GetMapping("/all/")
	public List<Policy> findAll(){
		return policyService.findAll();
	}
	
	@PutMapping("/updatepolicy/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable int id, @RequestBody Policy p){
		Policy policy = policyService.updatePolicy(id, p);
		
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Policy> deletePolicy(@PathVariable int id){
		Policy policy = policyService.deletePolicy(id);
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}

}
