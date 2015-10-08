package com.njby.mvc.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.njby.entity.Log;
import com.njby.service.AdminService;
import com.njby.service.LogConfigService;
import com.njby.service.LogService;
import com.njby.utils.LogConfig;

public class LogInterceptor extends HandlerInterceptorAdapter{
	private static AntPathMatcher antPathMatcher = new AntPathMatcher();
	private String[] ignoreParameters = { "password", "rePassword",
			"currentPassword" };
	@Resource
	private LogConfigService logConfigService;
	@Resource
	private LogService logService;
	@Resource
	private AdminService adminService;
	
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		List<LogConfig> logconfigs = this.logConfigService.getAll();
		if (logconfigs != null) {
			String servletPath = request.getServletPath();
			Iterator<LogConfig> iterLogconfig = logconfigs.iterator();
			while (iterLogconfig.hasNext()) {
				LogConfig logConfig = (LogConfig) iterLogconfig.next();
				if (antPathMatcher.match(logConfig.getUrlPattern(), servletPath)) {
					String username = this.adminService.getCurrentUsername();
					String operation = logConfig.getOperation();
					String operator = username;
					String content = (String) request
							.getAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME);
					String ip = request.getRemoteAddr();
					request.removeAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME);
					StringBuffer parameter = new StringBuffer();
					Map parameterMap = request.getParameterMap();
					if (parameterMap != null) {
						Iterator it = parameterMap.entrySet().iterator();
						while (it.hasNext()) {
							Map.Entry entry = (Map.Entry) it.next();
							String key = (String) ((Map.Entry) entry).getKey();
							if (!ArrayUtils.contains(this.ignoreParameters,
									key)) {
								String[] values = (String[]) ((Map.Entry) entry)
										.getValue();
								if (values != null) {
									for (String value : values) {
										parameter.append(key + " = " + value + "\n");
									}
								}
							}
						}
					}
					Log log = new Log();
					log.setOperation(operation);
					log.setOperator(operator);
					log.setContent(content);
					log.setParameter(parameter.toString());
					log.setIp(ip);
					this.logService.save(log);
					break;
				}
			}
		}
	}	
	
	public String[] getIgnoreParameters() {
		return this.ignoreParameters;
	}

	public void setIgnoreParameters(String[] ignoreParameters) {
		this.ignoreParameters = ignoreParameters;
	}
}
