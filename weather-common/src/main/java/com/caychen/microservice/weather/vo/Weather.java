package com.caychen.microservice.weather.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.vo.Weather
 * Date:         2019/5/29
 * Version:      v1.0
 * Desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {

	private String city;//城市

	@JSONField(name = "aqi")
	private String airQualityIndex;//空气质量指数

	@JSONField(name = "ganmao")
	private String tip;//温馨提示

	@JSONField(name = "wendu")
	private String temperature;//温度

	private Yesterday yesterday;//昨日天气

	private List<Forecast> forecast;//未来天气
}
