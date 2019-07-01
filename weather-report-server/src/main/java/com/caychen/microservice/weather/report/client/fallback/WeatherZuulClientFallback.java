package com.caychen.microservice.weather.report.client.fallback;

import com.caychen.microservice.weather.report.client.WeatherZuulClient;
import com.caychen.microservice.weather.vo.City;
import com.caychen.microservice.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Component
public class WeatherZuulClientFallback implements WeatherZuulClient {

	@Override
	public List<City> listCity() throws Exception {
		return Collections.singletonList(new City("101190402", "changshu", "常熟", "江苏"));
	}

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		return null;
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		return null;
	}
}
