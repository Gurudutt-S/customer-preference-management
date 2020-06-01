package com.cts.superstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cts.superstore.configuration.TypeSafeConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableConfigurationProperties(TypeSafeConfiguration.class)
public class GetCustomerIdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetCustomerIdServiceApplication.class, args);
	}

}
