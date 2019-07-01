package com.caychen.microservice.weather.report.controller;

import com.caychen.microservice.weather.report.client.ICityClient;
import com.caychen.microservice.weather.report.client.WeatherZuulClient;
import com.caychen.microservice.weather.report.service.IWeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Controller
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private ICityClient cityClient;

	@Autowired
	private WeatherZuulClient weatherZuulClient;

	@Autowired
	private IWeatherReportService weatherReportService;

	@GetMapping("/id/{cityId}")
	public String getReportByCityId(@PathVariable("cityId") String cityId, ModelMap model) throws Exception {

		model.addAttribute("title", "caychen的天气预报");
		model.addAttribute("cityId", cityId);

		//直连
//		model.addAttribute("cityList", cityClient.listCity());
		//zuul
		model.addAttribute("cityList", weatherZuulClient.listCity());

		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

		return "weather/report";
	}

}
