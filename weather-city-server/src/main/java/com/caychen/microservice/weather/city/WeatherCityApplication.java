package com.caychen.microservice.weather.city;

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
public class WeatherCityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCityApplication.class, args);
	}
}
