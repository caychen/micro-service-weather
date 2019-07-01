package com.caychen.microservice.weather.data.serivce.impl;

import com.alibaba.fastjson.JSON;
import com.caychen.microservice.weather.common.Constant;
import com.caychen.microservice.weather.common.enums.ExceptionEnum;
import com.caychen.microservice.weather.data.serivce.IWeatherDataService;
import com.caychen.microservice.weather.utils.UrlUtils;
import com.caychen.microservice.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements IWeatherDataService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		log.info("查询城市id为[{}]的天气数据...", cityId);
		String idKey = UrlUtils.generateRedisKey(Constant.REDIS_PREFIX, "id", cityId);
		return getWeatherResponse(idKey);

	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		log.info("查询城市名称为[{}]的天气数据...", cityName);
		String nameKey = UrlUtils.generateRedisKey(Constant.REDIS_PREFIX, "name", cityName);
		return getWeatherResponse(nameKey);
	}

	private WeatherResponse getWeatherResponse(String key) {
		String content = "";
		if (!stringRedisTemplate.hasKey(key)) {
			try {
				log.info("Redis没有对应[{}]的值！", key);
				return new WeatherResponse(null,  0,"Don't have Data");
			} catch (Exception e) {
				log.error(ExceptionEnum.REMOTE_CALL_EXCEPTION.getDesc(), e);
				return new WeatherResponse(null, ExceptionEnum.REMOTE_CALL_EXCEPTION.getCode(), e.getMessage());
			}
		} else {
			log.info("Redis有对应[{}]的值！", key);
			content = stringRedisTemplate.opsForValue().get(key);
		}

		WeatherResponse weatherResponse = JSON.parseObject(content, WeatherResponse.class);
		return weatherResponse;
	}
}
