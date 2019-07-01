package com.caychen.microservice.weather.city.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.utils.CityListXmlBuilder
 * Date:         2019/6/4
 * Version:      v1.0
 * Desc:
 */
public class CityListXmlBuilder {

	public static <T> T xmlStrToObject(Class<T> clazz, String xmlStr) throws JAXBException {
		T obj = null;

		JAXBContext context = JAXBContext.newInstance(clazz);

		// XML 转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();

		StringReader reader = new StringReader(xmlStr);

		obj = (T) unmarshaller.unmarshal(reader);

		if(reader != null){
			reader.close();
		}

		return obj;
	}
}
