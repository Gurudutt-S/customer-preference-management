package com.cts.superstore.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.superstore")).paths(PathSelectors.any()).build()
				.apiInfo(apiDetails());

	}

	public ApiInfo apiDetails() {

		return new ApiInfo("SuperStore API", "sample project", "1.0", "free to use",
				new springfox.documentation.service.Contact("batch7AA", "abc.com", "hameemsha121@gmail.com"),
				"API license", "http.abc.io", Collections.EMPTY_LIST);
	}

}
