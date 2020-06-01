package com.cts.superstore.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("admin")
          .password(encoder.encode("password"))
          .roles("ADMIN");
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/get-customer-id-service/**").hasAnyRole("USER","ADMIN")
        .antMatchers("/**").permitAll()
		.anyRequest().hasAnyRole("USER","ADMIN");
	}
}