package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring boot 啟動完成前先執行此配置
public class ModelMapperConfig {
	
	// 給 Spring boot 自動建立物件以及管理依賴
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
