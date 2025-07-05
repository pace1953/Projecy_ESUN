package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.EmployeeException;
import com.example.demo.model.dto.EmployeeDto;

public interface EmployeeService {

	// 查詢所有員工
	List<EmployeeDto> getAllEmp();
	
	// 安排座位
	public void seatingToEmp(Integer empId, Integer seatSeq) throws EmployeeException;
	
	// 清除座位
	public void deleteSeatingToEmp(Integer empId) throws EmployeeException;
	
	// 檢查員工有沒有座位
	boolean checkEmpHasSeating(Integer empId);
	
	// 檢查座位有沒有被占用
	boolean checkSeatingIsOccupied(Integer seatSeq);
	
}
