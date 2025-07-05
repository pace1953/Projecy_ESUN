package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatOccupancyDto {
	// 座位的資訊
	private Integer seatSeq;
	private Integer floorNo;
	private Integer seatNo;
	
	// 占用該座位的員工
	private Integer empId;
	private String empName;
}
