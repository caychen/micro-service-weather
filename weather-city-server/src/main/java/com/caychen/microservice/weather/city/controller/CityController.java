package com.caychen.microservice.weather.city.controller;

import com.caychen.microservice.weather.city.service.ICityService;
import com.caychen.microservice.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@RestController
@RequestMapping("/cities")
@Slf4j
public class CityController {

	@Autowired
	private ICityService cityService;

	@GetMapping({"/", "/list"})
	public List<City> listCity() throws Exception {
		log.info("请求城市列表...");
		return cityService.listCity();
	}

}
