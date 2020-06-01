package com.cts.superstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.superstore.entity.CustomerPreferenceEntity;
import com.cts.superstore.model.CustomerPreference;
import com.cts.superstore.service.CustomerPreferenceService;
import com.cts.superstore.validator.CustomerPreferenceValidator;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/cts/superstore")
public class CustomerPreferenceController {

	@Autowired
	Environment environment;

	@Autowired
	CustomerPreferenceService customerPreferenceService;

	@Autowired
	CustomerPreferenceValidator validator;

	@PutMapping(value = "/customer", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> update(@RequestBody CustomerPreference preferenceReq) {
		log.info("Inside Customer Preference:get details");
		String error = validator.validate(preferenceReq);

		if (error.equals(" ")) {
			CustomerPreferenceEntity customerPreferenceEntity = customerPreferenceService
					.updateCustomerPreference(preferenceReq);
			return new ResponseEntity<>(customerPreferenceEntity, HttpStatus.OK);
		}
		if (error.equals("emailError"))
			return new ResponseEntity<String>("Error in Email Format", HttpStatus.NOT_ACCEPTABLE);
		if (error.equals("nameError"))
			return new ResponseEntity<String>("Error in Name Format", HttpStatus.NOT_ACCEPTABLE);
		if (error.equals("phoneError"))
			return new ResponseEntity<String>("Error in phone Format", HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<String>("Validation Error", HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping(value = "/customer", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getAllCustomers() {
		List<CustomerPreferenceEntity> customersList = customerPreferenceService.getAllCustomers();
		if (customersList.size() > 0) {
			return new ResponseEntity<List>(customersList, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No data", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/ribbon")
	public String ribbonTest() {
		return "ribbon working and running on port" + environment.getProperty("local.server.port");
	}

}
