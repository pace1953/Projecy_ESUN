package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
	
	// 員工編號
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID", nullable = false)
	private Integer empId;
	
	// 員工姓名
	@Column(name = "NAME", nullable = false)
	private String empName;
	
	// 員工電子郵件
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String empEmail;
	
	// FK 關聯 seatSeq
	@Column(name = "FLOOR_SEAT_SEQ", nullable = true)
	private Integer seatSeq;
	
}
