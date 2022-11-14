package com.Restexample.Restdemo.Expense;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="tbl_expense")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="expense_name")
	@NotBlank(message="Expense name must not be null")
	@Size(min=3,message="Expense name atleast 3 character")
	private String name;
	
	private String description;
	@Column(name="expense_amount")
	@NotNull(message="Expense amount should not be null")
	private BigDecimal amount;
	
	@NotNull(message="Category amount should not be null")
	private String category;
	@NotNull(message="Date amount should not be null")
	private Date date;
	@Column(name="created_at",nullable=false,updatable=false)
	@CreationTimestamp
	private Date createdAt;
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date UpdatedAt;
	
	

	public Expense()
	{
		
	}


	public Expense(String name, String description, BigDecimal amount, String category, Date date, Date createdAt,
			Date updatedAt) {
		super();
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.date = date;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
		return "Expense [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
				+ ", category=" + category + ", date=" + date + ", createdAt=" + createdAt + ", UpdatedAt=" + UpdatedAt
				+ "]";
	}

	
	
}

