package com.example.demo.controller;

import com.example.demo.exception.SeatingChartException;
import com.example.demo.model.dto.SeatOccupancyDto;
import com.example.demo.model.dto.SeatingChartDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.SeatingChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/seat")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"}, allowCredentials = "true")
public class SeatingChartController {

    @Autowired
    private SeatingChartService seatingChartService;
    
    // 安全 Headers
    private <T> ResponseEntity<ApiResponse<T>> createResponse(ApiResponse<T> apiResponse, HttpStatus status) {
        return ResponseEntity.status(status)
                .header("X-XSS-Protection", "1; mode=block")
                .header("X-Content-Type-Options", "nosniff")
                .body(apiResponse);
    }

    // 查詢所有座位
    @GetMapping
    public ResponseEntity<ApiResponse<List<SeatingChartDto>>> getAllSeating() {
        try {
            List<SeatingChartDto> seats = seatingChartService.getAllSeating();
            return createResponse(ApiResponse.success("查詢座位成功", seats), HttpStatus.OK);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "查詢座位失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 查詢座位的占用
    @GetMapping("/occupancy")
    public ResponseEntity<ApiResponse<List<SeatOccupancyDto>>> getSeatingOccupancy() {
        try {
            List<SeatOccupancyDto> occupancy = seatingChartService.getSeatingOccupancy();
            return createResponse(ApiResponse.success("查詢座位佔用狀況成功", occupancy), HttpStatus.OK);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "查詢座位佔用狀況失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 用樓層跟座位號查詢座位的SEQ
    @GetMapping("/seq")
    public ResponseEntity<ApiResponse<Integer>> getSeatingSeq(@RequestParam Integer floorNo, @RequestParam Integer seatNo) {
        try {
            Integer seatSeq = seatingChartService.getSeatingSeq(floorNo, seatNo);
            return createResponse(ApiResponse.success("查詢座位序號成功", seatSeq), HttpStatus.OK);
        } catch (SeatingChartException e) {
            return createResponse(ApiResponse.error(404, e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return createResponse(ApiResponse.error(500, "查詢座位序號失敗: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}