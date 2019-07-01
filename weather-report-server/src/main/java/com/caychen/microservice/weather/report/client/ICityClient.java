package com.caychen.microservice.weather.report.client;

import com.caychen.microservice.weather.report.client.fallback.CityClientFallback;
import com.caychen.microservice.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@FeignClient(name = "weather-city-server", fallback = CityClientFallback.class)//直连city服务
public interface ICityClient {

	@GetMapping("/cities/")//直连city服务
	//前面的city为zuul的prefix，后面的cities为weather-city-server控制器中的前缀
	List<City> listCity() throws Exception;

}
