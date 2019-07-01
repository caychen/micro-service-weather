package com.caychen.microservice.weather.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@SpringBootApplication
@EnableEurekaServer
public class WeatherEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaServerApplication.class, args);
	}
}
