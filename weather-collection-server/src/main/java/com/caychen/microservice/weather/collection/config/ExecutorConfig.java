package com.caychen.microservice.weather.collection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.config.ExecutorConfig
 * Date:         2019/6/4
 * Version:      v1.0
 * Desc:
 */
@Configuration
public class ExecutorConfig {

	@Bean
	public TaskExecutor taskExecutor(){
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setMaxPoolSize(50);
		taskExecutor.setKeepAliveSeconds(60);
		taskExecutor.setThreadNamePrefix("taskExecutor-");

		return taskExecutor;
	}

}
