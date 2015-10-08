package com.njby.utils;


import java.util.Locale;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;


@Component("springUtils")
@Lazy(false)
public final class SpringUtils implements DisposableBean,
		ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void destroy() {
		applicationContext = null;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		Assert.hasText(name);
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		return applicationContext.getBean(name, type);
	}
	
	public static String getMessage(String code, Object... args) {
		LocaleResolver localeResolver = (LocaleResolver) getBean("localeResolver", LocaleResolver.class);
		Locale localLocale = localeResolver.resolveLocale(null);
		return applicationContext.getMessage(code, args, localLocale);
	}

}
