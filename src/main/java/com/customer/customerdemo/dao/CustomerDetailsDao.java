package com.customer.customerdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.customer.customerdemo.entity.CustomerDetails;

@Repository
@Component
public interface CustomerDetailsDao extends JpaRepository<CustomerDetails, Long> {
	
	@Query(value = "SELECT * FROM customerdetails c WHERE c.cust_mail_id = :mailId", nativeQuery = true)
	CustomerDetails findByCustMailId(String mailId);
	
	//CustomerDetails findById(Long id);
}
