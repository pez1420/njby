package com.njby.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.njby.service.LogConfigService;
import com.njby.utils.LogConfig;

@Service
public class LogConfigServiceImpl implements LogConfigService{

	@Cacheable({ "logConfig" })
	public List<LogConfig> getAll() {
		try {
			File file = new ClassPathResource("/system.xml").getFile();
			Document document = new SAXReader().read(file);
			List nodes = document.selectNodes("/system/logConfig");
			ArrayList<LogConfig> logconfigs = new ArrayList<LogConfig>();
			Iterator it = nodes.iterator();
			while (it.hasNext()) {
				Element element 	= (Element)it.next();
				String operation 	= element.attributeValue("operation");
				String urlPattern 	= element.attributeValue("urlPattern");
				LogConfig logConfig = new LogConfig();
				logConfig.setOperation(operation);
				logConfig.setUrlPattern(urlPattern);
				logconfigs.add(logConfig);
			}
			System.out.println("11111111111111111");
			System.out.println("2222222222222222222");
			return logconfigs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
