package com.caychen.microservice.weather.collection.job;

import com.caychen.microservice.weather.collection.client.ICityClient;
import com.caychen.microservice.weather.collection.service.IWeatherDataCollectionService;
import com.caychen.microservice.weather.common.exception.WeatherException;
import com.caychen.microservice.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author:       Caychen
 * Date:         2019/6/4
 * Desc:
 */
@Slf4j
@Component
public class WeatherDataSyncJob {

	@Autowired
	private IWeatherDataCollectionService weatherDataService;

	@Autowired
	private ICityClient cityClient;

	@Scheduled(cron = "0 0/1 * * * ?")
	public void syncData() {
		log.info("Weather Data Sync Job. Start！");

		// 获取城市ID列表
		List<City> cityList = null;

		try {
			cityList = cityClient.listCity();
			log.info("cityList.size() ==> [{}]", cityList.size());
		} catch (Exception e) {
			log.error("Exception: ", e);
		}

		// 遍历城市ID获取天气
		cityList.stream().forEach(city -> {
			String cityId = city.getId();
			String cityName = city.getCn();
			log.info("Weather Data Sync Job, cityId: [{}], cityName: [{}]", cityId, cityName);

			try {
				weatherDataService.syncDateByCityId(cityId);
				weatherDataService.syncDateByCityName(cityName);

			} catch (WeatherException e) {
//				e.printStackTrace();
				log.error("发生异常：", e);
			}

			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
			}

		});

		log.info("Weather Data Sync Job. End！");

	}

}
