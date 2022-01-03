package com.customer.customerdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.customerdemo.dto.CustomerDetailsDto;
import com.customer.customerdemo.entity.CustomerDetails;

@Service
public interface CustomerService {

	CustomerDetailsDto getById(Long id);

	CustomerDetailsDto createCustomer(CustomerDetailsDto cust);

	CustomerDetailsDto getByMailId(String mailId);

	List <CustomerDetails> getall();

	Boolean delete(Long id);

}
