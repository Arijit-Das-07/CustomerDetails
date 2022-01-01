package com.customer.customerdemo.service;

import org.springframework.stereotype.Service;

import com.customer.customerdemo.dto.CustomerDetailsDto;

@Service
public interface CustomerService {

	CustomerDetailsDto getById(Long id);

	CustomerDetailsDto createCustomer(CustomerDetailsDto cust);

	CustomerDetailsDto getByMailId(String mailId);

}
