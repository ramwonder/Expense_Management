package com.Restexample.Restdemo.Expense.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Restexample.Restdemo.Expense.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  
	//select * from tbl_expense where category=?
	 List<Expense> findByCategory(String category,Pageable page);
	 List<Expense> findByNameContaining(String name,Pageable page);	
	 List<Expense>  findByDateBetween(Date startdate,Date enddate,Pageable page);
}
