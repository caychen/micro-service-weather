package com.caychen.microservice.weather.collection.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.properties.WeatherUrlProperties
 * Date:         2019/5/29
 * Version:      v1.0
 * Desc:
 */
@Component
@ConfigurationProperties(prefix = "weather.url")
@Data
public class WeatherUrlProperties {

	private String byCityName;

	private String byCityKey;
}
