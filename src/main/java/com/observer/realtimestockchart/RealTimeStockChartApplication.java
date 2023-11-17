package com.observer.realtimestockchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RealTimeStockChartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeStockChartApplication.class, args);
	}
}
