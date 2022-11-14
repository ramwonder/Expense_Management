package com.Restexample.Restdemo.Expense.userService;

import java.util.List;

import com.Restexample.Restdemo.Expense.Users.User;
import com.Restexample.Restdemo.Expense.Users.UserModel;

public interface UserService {
	 User createuser(UserModel user);
	 User readUserById(Long id);
	 User UpdateUser(Long id,User user);
	 
	 void Delete(Long id);

}
