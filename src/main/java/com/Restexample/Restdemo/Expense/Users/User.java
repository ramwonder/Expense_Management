package com.Restexample.Restdemo.Expense.Users;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;


@Entity
@Table(name="tbl_users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    private String name;
	

    @Column(unique = true)
	private String email;
	
	
	private String password;
	
	private Long age;
    
    
	
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp private Date createdAt;
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date UpdatedAt;
	public User() {
		
	}
	public User( String name, @Email(message = "email should be in correct format") String email,
			String password, Long age, Date createdAt, Date updatedAt) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.createdAt = createdAt;
		UpdatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return UpdatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", createdAt=" + createdAt + ", UpdatedAt=" + UpdatedAt + "]";
	}
	
	

}
