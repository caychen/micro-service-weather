package com.caychen.microservice.weather.collection.client.fallback;

import com.caychen.microservice.weather.collection.client.ICityClient;
import com.caychen.microservice.weather.vo.City;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Component
public class CityClientFallback implements ICityClient {

	@Override
	public List<City> listCity() throws Exception {
		return Collections.singletonList(new City("101190402", "changshu", "常熟", "江苏"));
	}
}
