package com.customer.customerdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.customerdemo.dto.CustomerDetailsDto;
import com.customer.customerdemo.entity.CustomerDetails;
import com.customer.customerdemo.service.CustomerService;

@RestController
public class CustomerDetailscontroller {

	@Autowired
	private CustomerService customerService;

	@GetMapping("getbyid/{id}")
	public ResponseEntity<CustomerDetailsDto> getCustomer(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(this.customerService.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("getallcustomer")
	public ResponseEntity<List <CustomerDetails>> getCustomer() {
		try {
			return new ResponseEntity<>(this.customerService.getall(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("getbymailid/{mailId}")
	public ResponseEntity<CustomerDetailsDto> getCustomerByemail(@PathVariable String mailId) {
		try {
			return new ResponseEntity<>(this.customerService.getByMailId(mailId), HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<CustomerDetailsDto> saveCustomer( CustomerDetailsDto cust) {

		try {
			return new ResponseEntity<>(this.customerService.createCustomer(cust), HttpStatus.CREATED);

		}

		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        Boolean isRemoved = this.customerService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
