package com.caychen.microservice.weather.report.client.fallback;

import com.caychen.microservice.weather.report.client.WeatherDataClient;
import com.caychen.microservice.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Component
public class WeatherDataClientFallback implements WeatherDataClient {

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		return null;
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		return null;
	}
}
