package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.SeatingChartDto;
import com.example.demo.model.entity.SeatingChart;

@Component
public class SeatingChartMapper {
	
	@Autowired
	ModelMapper modelMapper;

	// Entity -> Dto
	public SeatingChartDto toDto(SeatingChart seatingChart) {
		return modelMapper.map(seatingChart, SeatingChartDto.class);
	}
	
	// Dto -> Entity
	public SeatingChart toEntity(SeatingChartDto seatingChartDto) {
		return modelMapper.map(seatingChartDto, SeatingChart.class);
	}
}
