package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.SeatingChartException;
import com.example.demo.model.dto.SeatOccupancyDto;
import com.example.demo.model.dto.SeatingChartDto;

public interface SeatingChartService {

	// 查詢所有座位
	List<SeatingChartDto> getAllSeating();
	
	// 查詢座位的占用
	List<SeatOccupancyDto> getSeatingOccupancy();
	
	// 查詢座位SEQ(透過樓層跟座位號)
	public Integer getSeatingSeq(Integer floorNo, Integer seatNo) throws SeatingChartException;

}
