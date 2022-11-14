package com.Restexample.Restdemo.Expense.Users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel {
	@NotBlank(message="please Enter Name")
	private String name;
	@NotNull(message="please Enter Email")
	@Email(message="please should enter correct format email")
	private String email;
    @Size(min=7,message="password length should be 7")
	private String password;

	private Long age=0L;
	public UserModel() {
		
	}
	public UserModel(String name, String email, String password, Long age) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

}
