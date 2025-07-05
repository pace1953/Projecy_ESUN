package com.example.demo.exception;

public class SeatingChartException extends RuntimeException{
	public SeatingChartException(String message) {
		super(message);
	}
	
	public SeatingChartException(String message, Throwable err) {
		super(message, err);
	}
}
