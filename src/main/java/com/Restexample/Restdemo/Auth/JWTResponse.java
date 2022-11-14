package com.Restexample.Restdemo.Auth;

import lombok.AllArgsConstructor;


public class JWTResponse {

	private final String jwtToken;

	


	public JWTResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}




	public String getJwtToken() {
		return jwtToken;
	}
	




	
	
}
