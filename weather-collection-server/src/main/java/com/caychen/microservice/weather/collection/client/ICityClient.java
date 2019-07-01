package com.caychen.microservice.weather.collection.client;

import com.caychen.microservice.weather.collection.client.fallback.CityClientFallback;
import com.caychen.microservice.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
//@FeignClient(name = "weather-city-server")//直连city服务
@FeignClient(name = "weather-zuul-server", fallback = CityClientFallback.class)//连接zuul网关
public interface ICityClient {

//	@GetMapping("/cities/")//直连city服务
	@GetMapping("/city/cities/")
	//前面的city为zuul的prefix，后面的cities为weather-city-server控制器中的前缀
	List<City> listCity() throws Exception;

}
