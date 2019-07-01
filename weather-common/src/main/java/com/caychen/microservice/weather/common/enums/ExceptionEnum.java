package com.caychen.microservice.weather.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Author:       Caychen
 * Enum:         com.caychen.weather.app.common.enums.ExceptionEnum
 * Date:         2019/5/30
 * Version:      v1.0
 * Desc:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
	INVALID_PARAMS_EXCEPTION(100, "参数不合法"),
	JSON_SERIALIZER_EXCEPTION(101, "序列化json异常"),
	JSON_DESERIALIZER_EXCEPTION(102, "反序列化json异常"),
	REMOTE_CALL_EXCEPTION(103, "远程调用失败"),
	;

	private int code;

	private String desc;
}
