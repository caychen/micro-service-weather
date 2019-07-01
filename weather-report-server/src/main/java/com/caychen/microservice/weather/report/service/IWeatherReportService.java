package com.caychen.microservice.weather.report.service;


import com.caychen.microservice.weather.vo.Weather;

/**
 * Author:           Caychen
 * Interface:        com.caychen.weather.app.service.IWeatherReportService
 * Date:             2019/6/4
 * Version:          v1.0
 * Desc:
 */
public interface IWeatherReportService {

	Weather getDataByCityId(String cityId);

	Weather getDataByCityName(String cityName);
}
