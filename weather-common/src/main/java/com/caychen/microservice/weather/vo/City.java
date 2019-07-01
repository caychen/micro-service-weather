package com.caychen.microservice.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.vo.City
 * Date:         2019/6/4
 * Version:      v1.0
 * Desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

	@XmlAttribute(name = "id")
	private String id;

	@XmlAttribute(name = "en")
	private String en;

	@XmlAttribute(name = "cn")
	private String cn;

	@XmlAttribute(name = "province")
	private String province;
}
