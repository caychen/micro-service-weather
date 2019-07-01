package com.caychen.microservice.weather.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author:       Caychen
 * Class:        com.caychen.microservice.weather.WeatherReportApplication
 * Date:         2019/6/15
 * Version:      v1.0
 * Desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WeatherReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherReportApplication.class, args);
	}
}
