package com.Restexample.Restdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Restexample.Restdemo.Auth.util.JwtRequestFiller;
import com.Restexample.Restdemo.Expense.userService.security.CustomerUserDetailsServices;



@Configuration
@EnableWebSecurity
public class Securityconfig {
	
	 @Autowired
	private CustomerUserDetailsServices userDetailsServices;
	 

	    @Bean
	    public  JwtRequestFiller jwtAuthenticationFilter() {
	        return new JwtRequestFiller();
	    }
	  @Bean
	   public SecurityFilterChain configure(HttpSecurity http) throws Exception {
			 http
					.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/login","/register","/").permitAll()
					.anyRequest().authenticated()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		            .and()
					.httpBasic();
			   http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
			  return http.build();
			
					
	    }
	  
//	  @Bean
//	    public InMemoryUserDetailsManager userDetailsService() {
//	     UserDetails user= User.withDefaultPasswordEncoder()
//	            .username("bushan")
//	            .password("12345")
//	            .roles("ADMIN")
//	            .build();
//	        return new InMemoryUserDetailsManager(user);
//
//	    }

	  @Bean
	    public AuthenticationManager authenticationManager(
	            AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
    
	 
	 
	    @Bean
	    PasswordEncoder passwordEncoder() {
	    	return  new BCryptPasswordEncoder();

	    }
}
