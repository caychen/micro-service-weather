package com.caychen.microservice.weather.data.controller;

import com.caychen.microservice.weather.data.serivce.IWeatherDataService;
import com.caychen.microservice.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherDataController {

	@Autowired
	private IWeatherDataService weatherDataService;

	@GetMapping("/city/id/{cityId}")
	public WeatherResponse getByCityId(HttpServletRequest request, @PathVariable String cityId){
		log.info("请求城市id: [{}]", cityId);

		log.info("X-B3-TraceId: [{}]", request.getHeader("X-B3-TraceId"));
		log.info("X-B3-SpanId: [{}]", request.getHeader("X-B3-SpanId"));
		log.info("X-B3-ParentSpanId: [{}]", request.getHeader("X-B3-ParentSpanId"));
		log.info("X-Span-Export: [{}]", request.getHeader("X-Span-Export"));

		return weatherDataService.getDataByCityId(cityId);
	}

	@GetMapping("/city/name/{cityName}")
	public WeatherResponse getByCityName(@PathVariable String cityName){
		log.info("请求城市name: [{}]", cityName);
		return weatherDataService.getDataByCityName(cityName);
	}
}
