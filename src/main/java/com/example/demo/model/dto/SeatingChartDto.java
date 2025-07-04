package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatingChartDto {
	private Integer seatSeq;
	private Integer floorNo;
	private Integer seatNo;
}
