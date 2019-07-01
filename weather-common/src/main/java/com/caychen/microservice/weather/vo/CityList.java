package com.caychen.microservice.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.vo.CityList
 * Date:         2019/6/4
 * Version:      v1.0
 * Desc:
 */
@XmlRootElement(name = "city-list")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityList {

	@XmlElement(name = "city")
	private List<City> cityList;
}
