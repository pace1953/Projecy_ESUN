package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entity.Employee;

@Component
public class EmployeeMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	// Entity -> Dto
	public EmployeeDto toDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}
	
	// Dto -> Entity
	public Employee toEntity(EmployeeDto employeeDto) {
		return modelMapper.map(employeeDto, Employee.class);
	}
}
