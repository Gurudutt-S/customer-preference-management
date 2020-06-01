package com.cts.superstore.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;

import com.cts.superstore.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GetCustomerIdValidator {
	public boolean validate(Customer req) {

		if (isValidateEmailAddress(req.getEmail()) == false) {
			log.info("error in the email format");
			return false;
		}
		if (isValidateName(req.getName()) == false || req.getName() == null) {
			log.info("Check the format of name");
			return false;
		}
		if (isValidatePhone(req.getPhone()) == false) {
			log.info("check the format of phone");
			return false;
		}
		return true;
	}

	private boolean isValidatePhone(long phone) {
		String phoneNumber = Long.toString(phone);
		Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

	private boolean isValidateName(String name) {
		String regex = "[aA-zZ]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();

	}

	public static boolean isValidateEmailAddress(String emailId) {
		String regex = "^(.+)@(.+)(.com)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
	}

}
