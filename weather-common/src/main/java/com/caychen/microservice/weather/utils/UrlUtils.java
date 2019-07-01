package com.caychen.microservice.weather.utils;

import com.caychen.microservice.weather.common.Constant;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
public class UrlUtils {

	public static String generateRedisKey(String prefix, String... args) {
		StringBuilder sb = new StringBuilder();

		sb.append(prefix);
		for (String arg : args) {
			sb.append(Constant.SPLITTOR).append(arg);
		}

		return sb.toString();
	}
}
