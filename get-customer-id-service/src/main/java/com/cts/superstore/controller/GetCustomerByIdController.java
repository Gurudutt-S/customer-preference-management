package com.cts.superstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.superstore.configuration.TypeSafeConfiguration;
import com.cts.superstore.model.Customer;

import com.cts.superstore.service.GetCustomerIdServiceImplementation;
import com.cts.superstore.validator.GetCustomerIdValidator;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@CrossOrigin(origins = "*")
@RestController
@EnableHystrix
@Slf4j
@RequestMapping("/cts/superstore")
public class GetCustomerByIdController {

	@Autowired
	TypeSafeConfiguration message;

	@Autowired
	CustomerPreferenceProxy proxy;

	@Autowired
	GetCustomerIdServiceImplementation service;

	@Autowired
	GetCustomerIdValidator validator;

	@GetMapping(value = "/customer/{custId}")
	@HystrixCommand(fallbackMethod = "errorMessage")
	public ResponseEntity<?> getCustomerByCustId(@PathVariable("custId") int custId) {

		Customer customer = service.findByCustId(custId);
		boolean valid = validator.validate(customer);

		if (valid) {
			log.info("Getting Customer by customer id--> {}", customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Validation error", HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<?> errorMessage(@PathVariable("id") int id) {
		log.info("no data");
		return new ResponseEntity<String>("no user registered with id: " + id + "\nmessage : " + message.getMessage(),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/customer")
	public ResponseEntity<?> getAllCustomers() {

		ResponseEntity<?> customers = proxy.getAllCustomers();
		return customers;

	}

	@GetMapping("/ribbon")
	public String ribbonTest() {
		String ribbonString = proxy.ribbonTest();
		return ribbonString;
	}

}
