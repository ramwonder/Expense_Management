package com.Restexample.Restdemo.Expense;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorObject {
	private Integer statusCode;
	private String message;
	private Date timeStamp;
	public ErrorObject()
	{
		
	}
	public ErrorObject(Integer statusCode, String message, Date timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}

