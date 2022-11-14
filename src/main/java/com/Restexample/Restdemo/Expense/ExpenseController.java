package com.Restexample.Restdemo.Expense;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {
    
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses()
	{
		return expenseService.getAllExpense();
	}
	
	@GetMapping("/expenses/{id}")
	public Expense GetAllExpenseById(@PathVariable Long id)
	{
		
		return expenseService.GetExpenseById(id);
	}
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses/{id}")
	public String DeleteExpenseById(@PathVariable Long id)
	{
		
		expenseService.DeleteExpenseById(id);
		return "Record deleted Successfully"+id;
	}
	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense PostExpense(@Valid @RequestBody Expense expense)
	{
		return expenseService.postExpense(expense);
	}
	
	@PutMapping("/expenses/{id}")
	public Expense UpdateExpense(@PathVariable Long id,@RequestBody Expense expense)
	{
		return expenseService.UpdateExpense(id,expense);
	}
	
	@GetMapping("/expenses/category")
	public List<Expense> getExpensebycategory(@RequestParam String category,Pageable page)

	{
		return expenseService.readyBycategory(category, page);
	}
	@GetMapping("/expenses/name")
	public List<Expense> getExpensebyname(@RequestParam String name,Pageable page)

	{
		return expenseService.readyByname(name, page);
	}
	@GetMapping("/expenses/date")
	public List<Expense> getExpensebyname(@RequestParam (required=false) @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate,@RequestParam  (required=false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,Pageable page)

	{
		return expenseService.readyBydatebetween(startDate, endDate, page);
	}
	
}
