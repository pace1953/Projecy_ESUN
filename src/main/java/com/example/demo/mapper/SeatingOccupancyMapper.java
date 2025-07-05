package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.model.dto.SeatOccupancyDto;

@Component
public class SeatingOccupancyMapper {
	
	// 把 SP 回傳的 Object[] 轉 Dto
	public SeatOccupancyDto toDto(Object[] spData) {
		SeatOccupancyDto SODto = new SeatOccupancyDto();
		SODto.setSeatSeq((Integer) spData[0]);
		SODto.setFloorNo((Integer) spData[1]);
		SODto.setSeatNo((Integer)spData[2]);
		SODto.setEmpId((Integer)spData[3]);
		SODto.setEmpName((String)spData[4]);
		return SODto;
	}
}
