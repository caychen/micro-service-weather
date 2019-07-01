package com.caychen.microservice.weather.city.service.impl;

import com.caychen.microservice.weather.city.service.ICityService;
import com.caychen.microservice.weather.city.utils.CityListXmlBuilder;
import com.caychen.microservice.weather.vo.City;
import com.caychen.microservice.weather.vo.CityList;
import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.service.impl.CityServiceImpl
 * Date:         2019/6/4
 * Version:      v1.0
 * Desc:
 */
@Service
@Slf4j
public class CityServiceImpl implements ICityService {

	@Value("${city.file}")
	private String cityFileName;

	@Override
	public List<City> listCity() throws Exception {
		log.info("加载文件名：[{}]", cityFileName);
		ClassPathResource resource = new ClassPathResource(cityFileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), Charsets.UTF_8));

		StringBuilder sb = new StringBuilder();
		String line;

		while((line = reader.readLine()) != null){
			sb.append(line);
		}

		CityList cityList = CityListXmlBuilder.xmlStrToObject(CityList.class, sb.toString());

		return cityList.getCityList();
	}
}
