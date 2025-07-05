package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.SeatingChart;

@Repository
public interface SeatingChartRepository extends JpaRepository<SeatingChart, Integer>{
	
	// 查詢所有的座位 (SP -> getAllSeats())
	@Query(value = "CALL getAllSeats()", nativeQuery = true)
	List<SeatingChart> getAllSeating();
	
	// 查詢座位的占用 (SP -> getSeatingOccupancy())
	@Query(value = "CALL getSeatingOccupancy()", nativeQuery = true)
	List<Object[]> getSeatingOccupancy();
	
	// 用樓層跟座位號找座位的SEQ (SP -> getSeatingSeq(:floorNo, :seatNo))
	@Query(value = "CALL getSeatingSeq(:floorNo, :seatNo)", nativeQuery = true)
	Integer getSeatingSeq(@Param("floorNo") Integer floorNo, @Param("seatNo") Integer seatNo);
}
