package com.njby.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.DeepUnwrap;


class InnerUtilsBean extends ConvertUtilsBean {
	public String convert(Object value) {
		if (value != null) {
			Class clazz = value.getClass();
			if ((clazz.isEnum()) && (super.lookup(clazz) == null)) {
				super.register(new EnumConverter(clazz), clazz);
			} else if ((clazz.isArray())
					&& (clazz.getComponentType().isEnum())) {
				if (super.lookup(clazz) == null) {
					ArrayConverter arrayConverter = new ArrayConverter(clazz,
							new EnumConverter(clazz.getComponentType()), 0);
					((ArrayConverter) arrayConverter).setOnlyFirstToString(false);
					super.register((Converter) arrayConverter, clazz);
				}
				Object localObject = super.lookup(clazz);
				return (String) ((Converter) localObject).convert(String.class,value);
			}
		}
		
		return super.convert(value);
	}

	public Object convert(String value, Class clazz) {
		if ((clazz.isEnum()) && (super.lookup(clazz) == null)) {
			super.register(new EnumConverter(clazz), clazz);
		}
		return super.convert(value, clazz);
	}

	public Object convert(String[] values, Class clazz) {
		if ((clazz.isArray()) && (clazz.getComponentType().isEnum())
				&& (super.lookup(clazz.getComponentType()) == null)) {
			super.register(new EnumConverter(clazz.getComponentType()),
					clazz.getComponentType());
		}
		return super.convert(values, clazz);
	}

	public Object convert(Object value, Class targetType) {
		if (super.lookup(targetType) == null) {
			if (targetType.isEnum()) {
				super.register(new EnumConverter(targetType), targetType);
			} else if ((targetType.isArray())
					&& (targetType.getComponentType().isEnum())) {
				ArrayConverter localArrayConverter = new ArrayConverter(
						targetType, new EnumConverter(
								targetType.getComponentType()), 0);
				localArrayConverter.setOnlyFirstToString(false);
				super.register(localArrayConverter, targetType);
			}
		}
		return super.convert(value, targetType);
	}
}

public final class FreemarkerUtils {
	private static final ConvertUtilsBean innerUtilsBean = new InnerUtilsBean();

	static {
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPatterns(CommonAttributes.DATE_PATTERNS);
		innerUtilsBean.register(dateConverter, Date.class);
	}
	
	public static String process(String template, Map<String, ?> model) {
		Configuration configuration = null;
		ApplicationContext applicationContext = SpringUtils
				.getApplicationContext();
		if (applicationContext != null) {
			FreeMarkerConfigurer freeMarkerConfigurer = (FreeMarkerConfigurer) SpringUtils
					.getBean("freeMarkerConfigurer", FreeMarkerConfigurer.class);
			if (freeMarkerConfigurer != null) {
				configuration = freeMarkerConfigurer.getConfiguration();
			}
		}
		return process(template, model, configuration);
	}

	public static String process(String template, Map<String, ?> model,
			Configuration configuration) {
		if (template == null) {
			return null;
		}
		if (configuration == null) {
			configuration = new Configuration();
		}
		StringWriter stringWriter = new StringWriter();
		try {
			new Template("template", new StringReader(template), configuration)
					.process(model,stringWriter);
		} catch (TemplateException templateException) {
			templateException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return stringWriter.toString();
	}
	
	public static <T> T getParameter(String name, Class<T> type,
			Map<String, TemplateModel> params) throws TemplateModelException {
		Assert.hasText(name);
		Assert.notNull(type);
		Assert.notNull(params);
		TemplateModel templateModel = (TemplateModel) params.get(name);
		if (templateModel == null) {
			return null;
		}
		Object localObject = DeepUnwrap.unwrap(templateModel);
		return (T) innerUtilsBean.convert(localObject, type);
	}

	public static TemplateModel getVariable(String name, Environment env) throws TemplateModelException {
		Assert.hasText(name);
		Assert.notNull(env);
		return env.getVariable(name);
	}

	public static void setVariable(String name, Object value, Environment env) throws TemplateModelException {
		Assert.hasText(name);
		Assert.notNull(env);
		if ((value instanceof TemplateModel)) {
			env.setVariable(name, (TemplateModel) value);
		} else {
			env.setVariable(name, ObjectWrapper.BEANS_WRAPPER.wrap(value));
		}
	}

	@SuppressWarnings("rawtypes")
	public static void setVariables(Map<String, Object> variables,
			Environment env) throws TemplateModelException {
		
		Assert.notNull(variables);
		Assert.notNull(env);
		
		Iterator iterator = variables.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if ((value instanceof TemplateModel)) {
				env.setVariable(key, (TemplateModel) value);
			} else {
				env.setVariable(key, ObjectWrapper.BEANS_WRAPPER.wrap(value));
			}
		}
	}	
}
