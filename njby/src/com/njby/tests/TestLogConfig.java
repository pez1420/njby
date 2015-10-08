package com.njby.tests;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.service.LogConfigService;
import com.njby.utils.LogConfig;

public class TestLogConfig {
	protected static LogConfigService logConfigService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 logConfigService = (LogConfigService)cxt.getBean("logConfigServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }	
	
	
	@Test
	public void getAll() {
		
		List<LogConfig> logConfigs = logConfigService.getAll();
		System.out.println("--------before------------");
		if (logConfigs != null) {
			for (LogConfig logconfig : logConfigs) {
				System.out.println(logconfig);
			}
		}
		System.out.println("--------after------------");
		logConfigs = logConfigService.getAll();
		if (logConfigs != null) {
					for (LogConfig logconfig : logConfigs) {
						System.out.println(logconfig);
					}
		}
		
		System.out.println("--------after------------");
		logConfigs = logConfigService.getAll();
		if (logConfigs != null) {
					for (LogConfig logconfig : logConfigs) {
						System.out.println(logconfig);
					}
		}		
		
	}
}
