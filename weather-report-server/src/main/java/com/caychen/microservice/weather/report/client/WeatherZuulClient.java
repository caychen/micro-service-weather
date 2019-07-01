package com.caychen.microservice.weather.report.client;

import com.caychen.microservice.weather.report.client.fallback.WeatherZuulClientFallback;
import com.caychen.microservice.weather.vo.City;
import com.caychen.microservice.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 * Tip：         @FeignClient中name为同一个值的话，需要把所有的方法放到同一个类中。
 */

@FeignClient(name = "weather-zuul-server", fallback = WeatherZuulClientFallback.class)//连接zuul网关服务
public interface WeatherZuulClient {

	@GetMapping("/city/cities/")
	//前面的city为zuul的prefix，后面的cities为weather-city-server控制器中的前缀
	List<City> listCity() throws Exception;

	@GetMapping("/data/weather/city/id/{cityId}")//连接zuul网关服务
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) ;

	@GetMapping("/data/weather/city/id/{cityName}")//连接zuul网关服务
	WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName);
}
