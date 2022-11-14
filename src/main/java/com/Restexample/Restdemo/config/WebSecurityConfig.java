//package com.Restexample.Restdemo.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@EnableWebSecurity
//public class WebSecurityConfig {
//	
//	 
//	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//			
//			return http
//					.csrf().disable()
//					.authorizeRequests()
//					.requestMatchers("login","/register","/").permitAll()
//					.anyRequest().authenticated()
//					.and()
//					.httpBasic()
//					.and().build();
//		  return http
//	                .csrf(csrf -> csrf.disable())
//	                .authorizeRequests(auth -> {
//	                    auth.requestMatchers("/").permitAll();
//	                    auth.requestMatchers("/user").hasRole("USER");
//	                    auth.requestMatchers("/admin").hasRole("ADMIN");
//	                })
//	                .httpBasic(withDefaults())
//	                .build();
//	    }
//  
//
//}
