package com.caychen.microservice.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Author:       Caychen
 * Class:        com.caychen.microservice.weather.WeatherZipkinServerApplication
 * Date:         2019/6/19
 * Desc:
 */
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class WeatherZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherZipkinServerApplication.class, args);
    }
}
