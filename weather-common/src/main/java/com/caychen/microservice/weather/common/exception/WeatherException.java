package com.caychen.microservice.weather.common.exception;

import lombok.NoArgsConstructor;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.common.exception.WeatherException
 * Date:         2019/5/30
 * Version:      v1.0
 * Desc:
 */
@NoArgsConstructor
public class WeatherException extends Exception {

	public WeatherException(String message) {
		super("");
	}

}
