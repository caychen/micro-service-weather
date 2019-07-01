package com.caychen.microservice.weather.report.client;

import com.caychen.microservice.weather.report.client.fallback.WeatherDataClientFallback;
import com.caychen.microservice.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 * Tip:         注意在使用Feign的时候，如果参数中带有@PathVariable形式的参数时，必须注明value=""对应的参数
 */

@FeignClient(name = "weather-data-server", fallback = WeatherDataClientFallback.class)//直连data服务
public interface WeatherDataClient {

	@GetMapping("/weather/city/id/{cityId}")//直连data服务
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) ;

	@GetMapping("/weather/city/id/{cityName}")//直连data服务
	WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName);
}
