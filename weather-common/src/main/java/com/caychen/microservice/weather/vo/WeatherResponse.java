package com.caychen.microservice.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.vo.WeatherResponse
 * Date:         2019/5/29
 * Version:      v1.0
 * Desc:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherResponse implements Serializable {

	private Weather data;

	private Integer status;

	private String desc;

}
