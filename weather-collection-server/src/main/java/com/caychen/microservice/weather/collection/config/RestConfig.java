package com.caychen.microservice.weather.collection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.config.RestConfig
 * Date:         2019/5/29
 * Version:      v1.0
 * Desc:
 */
@Configuration
public class RestConfig {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate(){
		return builder.build();
	}

}
