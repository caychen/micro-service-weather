package com.caychen.microservice.weather.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDataApplication.class, args);
	}
}
