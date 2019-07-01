package com.caychen.microservice.weather.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class WeatherZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherZuulApplication.class, args);
	}
}
