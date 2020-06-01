package com.cts.superstore.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RibbonClient("customer-preference-service")
@FeignClient("customer-preference-service")
public interface CustomerPreferenceProxy {

	@GetMapping("/cts/superstore/customer")
	public ResponseEntity<?> getAllCustomers();

	@GetMapping("/cts/superstore/ribbon")
	public String ribbonTest();

}
