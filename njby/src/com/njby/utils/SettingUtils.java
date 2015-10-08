package com.njby.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.io.IOUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.core.io.ClassPathResource;

import com.system.Setting;


public final class SettingUtils {
	private static final CacheManager cacheManager = CacheManager.create();
	private static final BeanUtilsBean beanUtilsBean;
	
	static {
		InnerUtilsBean innerUtilsBean = new InnerUtilsBean();
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPatterns(CommonAttributes.DATE_PATTERNS);
		innerUtilsBean.register(dateConverter, Date.class);
		beanUtilsBean = new BeanUtilsBean(innerUtilsBean);
	}

	public static Setting get() {
		Ehcache ehcache = cacheManager.getEhcache("setting");
		net.sf.ehcache.Element sfElement = ehcache.get(Setting.CACHE_KEY);
		
		Setting setting;
		if (sfElement != null) {
			setting = (Setting) sfElement.getObjectValue();
		} else {
			setting = new Setting();
			try {
				File file = new ClassPathResource("/system.xml").getFile();
				Document document = new SAXReader().read(file);
				List<?> settingList = document.selectNodes("/system/setting");
				Iterator<?> listIterator = settingList.iterator();
				while (listIterator.hasNext()) {
					org.dom4j.Element element = (org.dom4j.Element) listIterator.next();
					String name = element.attributeValue("name");
					String value = element.attributeValue("value");
					try {
						beanUtilsBean.setProperty(setting, name, value);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ehcache.put(new net.sf.ehcache.Element(Setting.CACHE_KEY, setting));
		}
		
		return setting;
	}

	public static void set(Setting setting) {
		try {
			File file = new ClassPathResource("/system.xml").getFile();
			Document document = new SAXReader().read(file);
			List<?> nodeList = document.selectNodes("/system/setting");
			Iterator<?> nodeIterator = nodeList.iterator();
			while (nodeIterator.hasNext()) {
				org.dom4j.Element domElement = (org.dom4j.Element) (nodeIterator).next();
				try {
					String name = domElement.attributeValue("name");
					String str2 = beanUtilsBean.getProperty(setting, name);
					Attribute attribute = domElement.attribute("value");
					attribute.setValue(str2);
				} catch (IllegalAccessException illegalAccessException) {
					illegalAccessException.printStackTrace();
				} catch (InvocationTargetException invocationTargetException) {
					invocationTargetException.printStackTrace();
				} catch (NoSuchMethodException noSuchMethodException) {
					noSuchMethodException.printStackTrace();
				}
			}
			
			FileOutputStream fileOutputStream = null;
			XMLWriter xmlWriter = null;
			try {
				OutputFormat outputFormat = OutputFormat.createPrettyPrint();
				outputFormat.setEncoding("UTF-8");
				outputFormat.setIndent(true);
				outputFormat.setIndent("\t");
				outputFormat.setNewlines(true);
				fileOutputStream = new FileOutputStream(file);
				xmlWriter = new XMLWriter((OutputStream) fileOutputStream,outputFormat);
				xmlWriter.write(document);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (xmlWriter != null) {
					try {
						((XMLWriter) xmlWriter).close();
					} catch (IOException e) {
					}
				}
				IOUtils.closeQuietly((OutputStream) fileOutputStream);
			}
			
			Ehcache ehcache = cacheManager.getEhcache("setting");
			ehcache.put(new net.sf.ehcache.Element(Setting.CACHE_KEY,setting));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}