package com.caychen.microservice.weather.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author:       Caychen
 * Class:        com.caychen.weather.app.vo.Yesterday
 * Date:         2019/5/29
 * Version:      v1.0
 * Desc:
 *
 * {
 *      "date":"28日星期二",
 *      "high":"高温 26℃",
 *      "fx":"东北风",
 *      "low":"低温 17℃",
 *      "fl":"<![CDATA[3-4级]]>",
 *      "type":"晴"
 * }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yesterday implements Serializable {

	private String date;//日期

	private String high;//最高温度

	@JSONField(name = "fx")
	private String windDirection;//风向

	private String low;//最低温度

	@JSONField(name = "fl")
	private String windPower;//风力

	@JSONField(name = "type")
	private String weatherType;//天气类型

}
