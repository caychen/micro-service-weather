package com.caychen.microservice.weather.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * Author:       Caychen
 * Date:         2019/6/15
 * Desc:
 */
@Component
public class RequestFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		long startTime = System.currentTimeMillis();
		RequestContext requestContext = RequestContext.getCurrentContext();
		requestContext.set("startTime", startTime);

		return null;
	}
}
