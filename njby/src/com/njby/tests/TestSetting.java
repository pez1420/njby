package com.njby.tests;

import java.util.HashMap;
import java.util.UUID;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.njby.utils.FreemarkerUtils;
import com.njby.utils.SettingUtils;
import com.njby.utils.SpringUtils;
import com.system.Setting;


public class TestSetting {
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mvc.xml", "applicationContext-mybatis.xml"});	 
		 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	@Test
	public void get() {
		Setting setting = SettingUtils.get();
		System.out.println(setting.getImageUploadPath());
		HashMap map = new HashMap();
        map.put("uuid", UUID.randomUUID().toString());
	}
	
	
}
