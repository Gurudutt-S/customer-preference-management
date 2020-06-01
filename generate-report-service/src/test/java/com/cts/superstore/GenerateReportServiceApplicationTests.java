package com.cts.superstore;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes=GenerateReportServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class GenerateReportServiceApplicationTests {

	@LocalServerPort
	private int port;
	HttpHeaders headers=new HttpHeaders();
	TestRestTemplate restTemplate=new TestRestTemplate();

	@Test
	void getReportByDate() {
		String url = "http://localhost:"+port+"cts/superstore/getreport";
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		String expected= "{\"id\":5" + 
				"	\"name\":\"hameem\"" + 
				"	\"preferedContact\":\"phone\"" + 
				"	\"preferedAddress\":\"home\"" + 
				"	\"deliveryTimings\":\"9-12\"" + 
				"	\"offerUpdates\":true" + 
				"	\"availableOnSunday\":true" + 
				"	\"updated\":\"2020-05-08\"" + 
				"	\"updatedBy\":\"customer\"}" ;
		assertTrue(response.getBody().contains(expected));		
		
		
	}

}
