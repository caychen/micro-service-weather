package com.caychen.microservice.weather.collection.service;

import com.caychen.microservice.weather.common.exception.WeatherException;

/**
 * Author:           Caychen
 * Interface:        com.caychen.weather.app.service.IWeatherDataCollectionService
 * Date:             2019/5/29
 * Version:          v1.0
 * Desc:
 */
public interface IWeatherDataCollectionService {

	void syncDateByCityId(String cityId) throws WeatherException;

	void syncDateByCityName(String cityName) throws WeatherException;

}
