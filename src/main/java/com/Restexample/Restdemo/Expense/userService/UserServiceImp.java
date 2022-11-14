package com.Restexample.Restdemo.Expense.userService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Restexample.Restdemo.Exception.CustomException;
import com.Restexample.Restdemo.Expense.Users.User;
import com.Restexample.Restdemo.Expense.Users.UserModel;
import com.Restexample.Restdemo.Expense.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public User createuser(UserModel usermodel) {
		// TODO Auto-generated method stub
		if (userRepository.existsByEmail(usermodel.getEmail())) {
			throw new CustomException("User is already registered with email:" + usermodel.getEmail());
		}
		User user = new User();
		BeanUtils.copyProperties(usermodel, user);
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User readUserById(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(() -> new CustomException("User not found by id " + id));
	}

	@Override
	public User UpdateUser(Long id,User user) {
		// TODO Auto-generated method stub
		User existinguser = readUserById(id);
		existinguser.setName(user.getName() != null ? user.getName() : existinguser.getName());
		existinguser.setEmail(user.getEmail() != null ? user.getEmail() : existinguser.getEmail());
		existinguser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword())  : existinguser.getPassword());
		existinguser.setAge(user.getAge() != null ? user.getAge() : existinguser.getAge());
		return userRepository.save(existinguser);
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
