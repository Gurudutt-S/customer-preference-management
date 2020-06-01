package com.cts.superstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.superstore.entity.CustomerEntity;

public interface GetCustomerIdRepository extends JpaRepository<CustomerEntity,Integer>{
	
	public CustomerEntity findByCustId(int cusId);

}
