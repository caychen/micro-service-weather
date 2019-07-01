package com.caychen.microservice.weather.collection;

import com.caychen.microservice.weather.collection.job.WeatherDataSyncJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;


@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
@EnableHystrix
@EnableHystrixDashboard
//首先访问http://ip:port/hystrix，然后http://ip:port/actuator/hystrix.stream
public class WeatherCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCollectionApplication.class, args);
	}

	@Autowired
	private WeatherDataSyncJob weatherDataSyncJob;

	@PostConstruct
	public void syncData(){
		log.info("系统启动完成，同步数据...");
		weatherDataSyncJob.syncData();
	}
}
