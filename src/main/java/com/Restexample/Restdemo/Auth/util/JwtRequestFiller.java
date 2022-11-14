package com.Restexample.Restdemo.Auth.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Restexample.Restdemo.Expense.userService.security.CustomerUserDetailsServices;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtRequestFiller extends OncePerRequestFilter {

	@Autowired
	private jwtTokenUtil jwtTokenUtil;
	@Autowired
	CustomerUserDetailsServices userDetailsServices;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		String username = null;
		// JWT token is in the form of "Bearer <token>". Remove bearer word and get only the token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
		jwtToken = requestTokenHeader.substring(7);
		try {
		username = jwtTokenUtil. getUsernameFromToken(jwtToken);
		} catch (IllegalArgumentException e) {
		throw new RuntimeException("Unable to get JWT Token");
		//System.out.println("Unable to get JWT Token");
		} catch (ExpiredJwtException e) {
		throw new RuntimeException("Jwt Token has expired");
		//System.out.println("Jwt Token has expired");
		}
		}
		
		if(username !=null &&SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails =userDetailsServices.loadUserByUsername(username);
		  if(jwtTokenUtil.validateToken(jwtToken, userDetails))
		  {
			  UsernamePasswordAuthenticationToken authToken=
					  new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
			  authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		      SecurityContextHolder.getContext().setAuthentication(authToken);
		  }
		  
		} 
		filterChain.doFilter(request, response);
	}

}
