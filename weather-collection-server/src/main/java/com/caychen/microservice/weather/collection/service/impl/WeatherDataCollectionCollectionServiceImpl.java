package com.caychen.microservice.weather.collection.service.impl;

import com.caychen.microservice.weather.collection.properties.WeatherUrlProperties;
import com.caychen.microservice.weather.collection.service.IWeatherDataCollectionService;
import com.caychen.microservice.weather.common.Constant;
import com.caychen.microservice.weather.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Author:       Caychen
 * Date:         2019/5/29
 * Desc:
 */
@Service
@Slf4j
public class WeatherDataCollectionCollectionServiceImpl implements IWeatherDataCollectionService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private WeatherUrlProperties urlProperties;

	@Override
	@Async
	public void syncDateByCityId(String cityId) {
		String url = urlProperties.getByCityKey() + cityId;
		String idKey = UrlUtils.generateRedisKey(Constant.REDIS_PREFIX,"id", cityId);
		this.syncWeatherData(idKey, url);
	}

	@Async
	@Override
	public void syncDateByCityName(String cityName) {
		String url = urlProperties.getByCityName() + cityName;
		String nameKey = UrlUtils.generateRedisKey(Constant.REDIS_PREFIX, "name", cityName);
		this.syncWeatherData(nameKey, url);
	}

	private void syncWeatherData(String key, String url) {
		String content = "";
		try {
			ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
			if (resp.getStatusCode() == HttpStatus.OK) {
				content = resp.getBody();
				stringRedisTemplate.opsForValue().set(key, content, Constant.TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			log.error("Sync " + key + " error: ", e);
		}

	}

}
