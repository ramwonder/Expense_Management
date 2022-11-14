package com.Restexample.Restdemo.Expense;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Restexample.Restdemo.Exception.CustomException;
import com.Restexample.Restdemo.Expense.repository.ExpenseRepository;
@Service
public class ExpenseIServicemp implements ExpenseService {
	 @Autowired
		private ExpenseRepository exprepository;
	
	@Override
	public List<Expense> getAllExpense() {
		// TODO Auto-generated method stub
		return  exprepository.findAll();
	}

	

	
	@Override
	public Expense GetExpenseById(Long id) {
		// TODO Auto-generated method stub
		
		
		Optional<Expense> exp=exprepository.findById(id);
		if(exp.isPresent())
		{
		return exp.get();
		}
		throw new CustomException("Expense is not found for id"+id);
	}





	@Override
	public Expense postExpense(Expense exp) {
		// TODO Auto-generated method stub
		
		return exprepository.save(exp);
	}




	@Override
	public void DeleteExpenseById(Long id) {
		// TODO Auto-generated method stub
		exprepository.deleteById(id);
		
	}




	@Override
	public Expense UpdateExpense(Long id, Expense expense) {
		// TODO Auto-generated method stub
		Expense existingExpense = GetExpenseById(id);
		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		return exprepository.save(existingExpense);
		
	}




	@Override
	public List<Expense> readyBycategory(String category, Pageable page) {
		// TODO Auto-generated method stub
		return exprepository.findByCategory(category, page);
	}




	@Override
	public List<Expense> readyByname(String name, Pageable page) {
		// TODO Auto-generated method stub
		return exprepository.findByNameContaining(name, page);
	}




	@Override
	public List<Expense> readyBydatebetween(Date startdate, Date enddaet, Pageable page) {
		// TODO Auto-generated method stub
		return exprepository.findByDateBetween(startdate, enddaet, page);
	}

}
