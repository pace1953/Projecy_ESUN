package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.SeatingChartException;
import com.example.demo.mapper.SeatingChartMapper;
import com.example.demo.mapper.SeatingOccupancyMapper;
import com.example.demo.model.dto.SeatOccupancyDto;
import com.example.demo.model.dto.SeatingChartDto;
import com.example.demo.model.entity.SeatingChart;
import com.example.demo.repository.SeatingChartRepository;
import com.example.demo.service.SeatingChartService;

@Service
public class SeatingChartServiceImpl implements SeatingChartService{

	@Autowired
	private SeatingChartRepository seatingChartRepository;
	
	@Autowired
	private SeatingChartMapper seatingChartMapper;
	
	@Autowired
	private SeatingOccupancyMapper seatingOccupancyMapper;
	
	@Override
	public List<SeatingChartDto> getAllSeating() {
		List<SeatingChart> seatingCharts = seatingChartRepository.getAllSeating();
		return seatingCharts.stream()
				.map(seatingChartMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<SeatOccupancyDto> getSeatingOccupancy() {
		List<Object[]> spData = seatingChartRepository.getSeatingOccupancy();
		return spData.stream()
				.map(seatingOccupancyMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public Integer getSeatingSeq(Integer floorNo, Integer seatNo) throws SeatingChartException {
	    try {
	        Integer seatSeq = seatingChartRepository.getSeatingSeq(floorNo, seatNo);
	        if (seatSeq == null) {
	            throw new SeatingChartException("查無此座位序列");
	        }
	        return seatSeq;
	    } catch (Exception e) {
	        throw new SeatingChartException("查詢座位序列發生錯誤：" + e.getMessage(), e);
	    }
	}
	

}
