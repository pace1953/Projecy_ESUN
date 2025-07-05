package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	// 查詢所有員工 (SP-> getAllEmp())
	@Query(value = "CALL getAllEmp()", nativeQuery = true)
	List<Employee> getAllEmp();
	
	// 更新員工的座位 (SP-> updateEmpSeating(:empId, :seatSeq))
	@Modifying
	@Query(value = "CALL updateEmpSeating(:empId, :seatSeq)", nativeQuery = true)
	void updateEmpSeating(@Param("empId") Integer empId, @Param("seatSeq") Integer seatSeq);
	
	// 刪除員工的座位 (SP -> deleteEmpSeating(:empId))
	@Modifying
	@Query(value = "CALL deleteEmpSeating(:empId)", nativeQuery = true)
	void deleteEmpSeating(@Param("empId") Integer empId);

}
