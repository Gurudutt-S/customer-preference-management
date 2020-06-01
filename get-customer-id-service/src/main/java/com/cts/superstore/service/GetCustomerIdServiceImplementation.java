package com.cts.superstore.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.superstore.entity.CustomerEntity;
import com.cts.superstore.model.Customer;
import com.cts.superstore.repository.GetCustomerIdRepository;
import com.cts.superstore.validator.GetCustomerIdValidator;

@Service
public class GetCustomerIdServiceImplementation {

	@Autowired
	GetCustomerIdRepository customerRepo;

	@Autowired
	GetCustomerIdValidator validator;

	public Customer findByCustId(int cusId) {
		CustomerEntity customerEntity = customerRepo.findByCustId(cusId);
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerEntity, customer);
		return customer;
	}

}
