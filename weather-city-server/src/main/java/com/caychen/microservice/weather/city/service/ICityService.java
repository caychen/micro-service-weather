package com.caychen.microservice.weather.city.service;

import com.caychen.microservice.weather.vo.City;

import java.util.List;

/**
 * Author:           Caychen
 * Interface:        com.caychen.weather.app.service.ICityService
 * Date:             2019/6/4
 * Version:          v1.0
 * Desc:
 */
public interface ICityService {

	/**
	 * 获取City列表
	 * @return
	 */
	List<City> listCity() throws Exception;
}
