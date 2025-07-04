package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Integer empId;
	private String empName;
	private String empEmail;
	
	// FK 
	// 關聯 seatSeq
	private Integer seatSeq;
}
