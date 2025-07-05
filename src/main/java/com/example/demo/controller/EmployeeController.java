package com.example.demo.controller;

import com.example.demo.exception.EmployeeException;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/emp")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"}, allowCredentials = "true")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    // 安全 Headers
    private <T> ResponseEntity<ApiResponse<T>> createResponse(ApiResponse<T> apiResponse, HttpStatus status) {
        return ResponseEntity.status(status)
                .header("X-XSS-Protection", "1; mode=block")
                .header("X-Content-Type-Options", "nosniff")
                .body(apiResponse);
    }
    
    // 查詢所有員工
    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeDto>>> getAllEmp() {
        try {
            List<EmployeeDto> employees = employeeService.getAllEmp();
            return createResponse(ApiResponse.success("查詢員工成功", employees), HttpStatus.OK);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "查詢員工失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 安排座位
    @PutMapping("/{empId}/{seatSeq}")
    public ResponseEntity<ApiResponse<String>> seatingToEmp(@PathVariable Integer empId, @PathVariable Integer seatSeq) {
        try {
            employeeService.seatingToEmp(empId, seatSeq);
            return createResponse(ApiResponse.success("座位分配成功", null), HttpStatus.OK);
        } catch (EmployeeException e) {
            return createResponse(ApiResponse.error(400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "座位分配失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 清除座位
    @DeleteMapping("/{empId}")
    public ResponseEntity<ApiResponse<String>> deleteSeatingToEmp(@PathVariable Integer empId) {
        try {
            employeeService.deleteSeatingToEmp(empId);
            return createResponse(ApiResponse.success("座位清除成功", null), HttpStatus.OK);
        } catch (EmployeeException e) {
            return createResponse(ApiResponse.error(400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "座位清除失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 檢查員工是否有座位
    @GetMapping("/{empId}/hasSeating")
    public ResponseEntity<ApiResponse<Boolean>> checkEmpHasSeating(@PathVariable Integer empId) {
        try {
            boolean hasSeat = employeeService.checkEmpHasSeating(empId);
            return createResponse(ApiResponse.success("檢查完成", hasSeat), HttpStatus.OK);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "檢查失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 檢查座位是否有人
    @GetMapping("/{seatSeq}/isOccupied")
    public ResponseEntity<ApiResponse<Boolean>> checkSeatingIsOccupied(@PathVariable Integer seatSeq) {
        try {
            boolean isOccupied = employeeService.checkSeatingIsOccupied(seatSeq);
            return createResponse(ApiResponse.success("檢查完成", isOccupied), HttpStatus.OK);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "檢查失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}