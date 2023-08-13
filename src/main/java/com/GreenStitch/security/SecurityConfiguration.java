package com.GreenStitch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.GreenStitch.jwt.Generator;
import com.GreenStitch.jwt.Validation;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain mySecurity(HttpSecurity http) throws Exception
	{

		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/**").hasAnyRole("USER")
				.anyRequest().authenticated()
				.and()
				.addFilterAfter(new Generator(), BasicAuthenticationFilter.class)
				.addFilterBefore(new Validation(), BasicAuthenticationFilter.class)
				.formLogin()
				.and()
				.httpBasic();


		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
