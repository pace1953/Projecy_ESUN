package com.example.demo.exception;

public class EmployeeException extends RuntimeException{
	public EmployeeException(String message) {
		super(message);
	}
	
	public EmployeeException(String message, Throwable err) {
		super(message, err);
	}
}
