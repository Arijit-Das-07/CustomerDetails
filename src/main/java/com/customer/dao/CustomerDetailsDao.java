package com.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.customer.customerdemo.entity.CustomerDetails;

@Repository
@Component
public interface CustomerDetailsDao extends JpaRepository<CustomerDetails, Long> {
	
	//CustomerDetails findById(Long id);
}
