package com.caychen.microservice.weather.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.vo.Forecast
 * Date:         2019/5/29
 * Version:      v1.0
 * Desc:
 *  {
 *      "date":"29日星期三",
 *      "high":"高温 26℃",
 *      "fengli":"<![CDATA[<3级]]>",
 *      "low":"低温 18℃",
 *      "fengxiang":"南风",
 *      "type":"多云"
 *  }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast implements Serializable {

	private String date;//日期

	private String high;//最高温度

	@JSONField(name = "fengli")
	private String windPower;//风力

	private String low;//最低温度

	@JSONField(name = "fx")
	private String windDirection;//风向

	@JSONField(name = "type")
	private String weatherType;//天气类型

}
