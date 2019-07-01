package com.caychen.microservice.weather.data.serivce;

import com.caychen.microservice.weather.vo.WeatherResponse;

/**
 * Author:           Caychen
 * Date:             2019/6/15
 * Desc:
 */
public interface IWeatherDataService {
	WeatherResponse getDataByCityId(String cityId);

	WeatherResponse getDataByCityName(String cityName);
}
