package com.caychen.microservice.weather.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class WeatherConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherConfigServerApplication.class, args);
	}
}
