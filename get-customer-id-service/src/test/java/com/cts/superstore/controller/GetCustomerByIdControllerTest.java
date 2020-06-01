package com.cts.superstore.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.superstore.model.Customer;
import com.cts.superstore.service.GetCustomerIdServiceImplementation;
import com.cts.superstore.validator.GetCustomerIdValidator;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetCustomerByIdControllerTest {

	@InjectMocks
	private GetCustomerByIdController controller;
	@Mock
	private GetCustomerIdServiceImplementation service;
	@Mock
	private GetCustomerIdValidator validator;

	@Test
	public void getCustomerByIdTest() {
		Customer customer = new Customer(1, 1234, "hameem", 9895253919L, "abc@gmail.com", "phone", "work", "home",
				"home", "9-12", true, true);
		when(service.findByCustId(1234)).thenReturn(customer);
		boolean valid = validator.validate(customer);
		if (valid) {
			Customer result = (Customer) controller.getCustomerByCustId(1234).getBody();
			assertEquals(customer.getName(), result.getName());
			verify(service, times(1)).findByCustId(1234);
		}

	}
}
