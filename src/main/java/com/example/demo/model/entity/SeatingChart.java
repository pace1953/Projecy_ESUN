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
@Table(name = "SeatingChart")
public class SeatingChart {

	// 序號
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "FLOOR_SEAT_SEQ", nullable = false)
	private Integer seatSeq;
	
	// 樓層編號
	@Column(name = "FLOOR_NO", nullable = false, unique = true)
	private Integer floorNo;
	
	// 座位編號
	@Column(name = "SEAT_NO", nullable = false, unique = true)
	private Integer seatNo;
}
