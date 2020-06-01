package com.cts.superstore.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "message")
public @Data class TypeSafeConfiguration {

	private String message;

}
