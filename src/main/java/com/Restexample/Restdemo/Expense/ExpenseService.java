package com.Restexample.Restdemo.Expense;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

public interface ExpenseService {

	List<Expense> getAllExpense();
	Expense GetExpenseById(Long id);
	Expense postExpense(Expense exp);
	void DeleteExpenseById(Long id);
	Expense UpdateExpense(Long id, Expense expense);
   List<Expense> readyBycategory(String category,Pageable page);
   List<Expense> readyByname(String name,Pageable page);
   List<Expense> readyBydatebetween(Date startdate,Date enddaet,Pageable page);
}
