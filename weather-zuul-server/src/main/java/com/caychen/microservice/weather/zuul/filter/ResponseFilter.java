package com.caychen.microservice.weather.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Component
@Slf4j
public class ResponseFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_FORWARD_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();

		Long startTime = (Long)requestContext.get("startTime");

		log.info("uri: [{}], 耗时: [{}]ms", request.getRequestURI(), System.currentTimeMillis() - startTime);

		return null;
	}
}
