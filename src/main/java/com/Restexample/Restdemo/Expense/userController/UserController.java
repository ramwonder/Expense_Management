package com.Restexample.Restdemo.Expense.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Restexample.Restdemo.Expense.Users.User;
import com.Restexample.Restdemo.Expense.Users.UserModel;
import com.Restexample.Restdemo.Expense.userService.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
    @Autowired
	UserService userService;
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> Save(@PathVariable Long id)
	{
		return  new ResponseEntity<User>(userService.readUserById(id),HttpStatus.OK);
		
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> Update(@PathVariable Long id,@Valid @RequestBody User user)
	{
		return  new ResponseEntity<User>(userService.UpdateUser(id, user),HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void DeleteUser(@PathVariable Long id)
	{
		userService.Delete(id);
		
	}
}

