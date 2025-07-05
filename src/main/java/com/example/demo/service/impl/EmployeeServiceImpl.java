package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.EmployeeException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeDto> getAllEmp() {
		List<Employee> employees = employeeRepository.getAllEmp();
		return employees.stream()
				.map(employeeMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void seatingToEmp(Integer empId, Integer seatSeq) throws EmployeeException{
		
		// 1. 先檢查該名員工目前有沒有座位
		if(checkEmpHasSeating(empId)) {
			throw new EmployeeException("該名員工已有座位");
		}
		
		// 2. 檢查安排的座位是否已經有員工入座
		if(checkSeatingIsOccupied(seatSeq)) {
			throw new EmployeeException("該座位已有員工入座");
		}
		
		// 3. 安排座位
		try {
			employeeRepository.updateEmpSeating(empId, seatSeq);
		} catch (Exception e) {
			throw new EmployeeException("安排座位失敗："+ e.getMessage(), e);
		}
		
	}

	@Override
	@Transactional
	public void deleteSeatingToEmp(Integer empId) throws EmployeeException {
		
		try {
			employeeRepository.deleteEmpSeating(empId);
		} catch (Exception e) {
			throw new EmployeeException("清除座位失敗：" + e.getMessage(), e);
		}
		
	}

	@Override
	public boolean checkEmpHasSeating(Integer empId) {
		List<Employee> employees = employeeRepository.getAllEmp();
		
		// 檢查每個員工有沒有座位
		for(Employee emp : employees) {
			if(emp.getEmpId().equals(empId)  && emp.getSeatSeq() != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkSeatingIsOccupied(Integer seatSeq) {
		List<Employee> employees = employeeRepository.getAllEmp();
		
		// 檢查每個座位上有沒有員工
		for(Employee emp : employees) {
			if(seatSeq.equals(emp.getSeatSeq())) {
				return true;
			}
		}
		return false;
	}

}
