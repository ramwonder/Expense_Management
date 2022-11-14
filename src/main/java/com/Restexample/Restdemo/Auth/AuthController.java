package com.Restexample.Restdemo.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Restexample.Restdemo.Auth.util.jwtTokenUtil;
import com.Restexample.Restdemo.Expense.Users.User;
import com.Restexample.Restdemo.Expense.Users.UserModel;
import com.Restexample.Restdemo.Expense.userService.UserService;
import com.Restexample.Restdemo.Expense.userService.security.CustomerUserDetailsServices;

import jakarta.validation.Valid;


@RestController
public class AuthController {
	@Autowired
	UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	CustomerUserDetailsServices customerUserDetailsServices;
	@Autowired
	private jwtTokenUtil  jwtTokenUtil;
	@PostMapping("/register")
	public ResponseEntity<User> Save(@Valid @RequestBody UserModel user) {
		return new ResponseEntity<User>(userService.createuser(user), HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<JWTResponse> login(@RequestBody LoginModel login) throws Exception {
	
    authenticate(login.getEmail(),login.getPassword());	
	final UserDetails userDetails= customerUserDetailsServices.loadUserByUsername(login.getEmail());
	
	final String token= jwtTokenUtil.generateToken(userDetails);
		return new ResponseEntity<JWTResponse>(new JWTResponse(token),HttpStatus.OK);
	}

	private void authenticate(String email, String password) throws Exception  {
		// TODO Auto-generated method stub
		
		try {
		   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
		}catch(DisabledException e)
		
		{
			throw new Exception("user disabled");
		}catch (BadCredentialsException e) {
		     throw new Exception("bad Credentials");
		}
	}

}
