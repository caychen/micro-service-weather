package com.caychen.microservice.weather.report.service.impl;

import com.caychen.microservice.weather.report.client.WeatherDataClient;
import com.caychen.microservice.weather.report.client.WeatherZuulClient;
import com.caychen.microservice.weather.report.service.IWeatherReportService;
import com.caychen.microservice.weather.vo.Weather;
import com.caychen.microservice.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:       Caychen
 * Date:         2019/6/4
 * Desc:
 */
@Service
public class WeatherReportServiceImpl implements IWeatherReportService {

	@Autowired
	private WeatherDataClient weatherDataClient;

	@Autowired
	private WeatherZuulClient weatherZuulClient;

	@Override
	public Weather getDataByCityId(String cityId) {
		//直连
//		WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
		//zuul
		WeatherResponse resp = weatherZuulClient.getDataByCityId(cityId);

		return resp != null ? resp.getData() : null;
	}

	@Override
	public Weather getDataByCityName(String cityName) {
		//直连
//		WeatherResponse resp = weatherDataClient.getDataByCityName(cityName);
		//zuul
		WeatherResponse resp = weatherZuulClient.getDataByCityName(cityName);
		return resp != null ? resp.getData() : null;
	}
}
