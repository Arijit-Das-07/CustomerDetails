package com.customer.customerdemo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customerdemo.dto.CustomerDetailsDto;
import com.customer.customerdemo.entity.CustomerDetails;
import com.customer.dao.CustomerDetailsDao;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDetailsDao customerDetailsDao;
	
	@Override
	public CustomerDetailsDto createCustomer(CustomerDetailsDto cust)
	{
		CustomerDetails customerDetails = new CustomerDetails();
		BeanUtils.copyProperties(cust,customerDetails);
		customerDetailsDao.save(customerDetails);
		CustomerDetailsDto custDto = new CustomerDetailsDto();
		BeanUtils.copyProperties(customerDetails, custDto);
		return custDto;	
	}
	
	public CustomerDetailsDto getById(Long id)
	{
		Optional<CustomerDetails> customerDetails = customerDetailsDao.findById(id);
		CustomerDetails custDetails = customerDetails.get();
		CustomerDetailsDto custDto = new CustomerDetailsDto();
		BeanUtils.copyProperties(custDetails, custDto);
		return custDto;		
	}
	
}
