package com.customer.customerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.customerdemo.dto.CustomerDetailsDto;
import com.customer.customerdemo.service.CustomerService;

@RestController
public class CustomerDetailscontroller {

	@Autowired
	private CustomerService customerService;
	
	
	 @GetMapping("getbyid/{id}")
	    public ResponseEntity<CustomerDetailsDto> getTodo( @PathVariable Long id) {
	        return new ResponseEntity<>(this.customerService.getById(id), HttpStatus.OK);
	    }
	    
	 @PostMapping("/create")   
	 	public ResponseEntity<CustomerDetailsDto> saveTodo(@RequestBody CustomerDetailsDto cust) {
		 return new ResponseEntity<>(this.customerService.createCustomer(cust),HttpStatus.CREATED);
	    
	    }
	
	
	
	
}
