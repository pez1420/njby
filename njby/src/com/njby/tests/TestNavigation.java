package com.njby.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Navigation;
import com.njby.service.NavigationService;


public class TestNavigation {
	protected static NavigationService navigationService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 navigationService = (NavigationService)cxt.getBean("navigationServiceImpl");
		 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	@Test
	public void save() {
		Navigation nav = new Navigation();
		
		nav.setName("首页");
		nav.setIsBlankTarget(Boolean.valueOf(false));
		nav.setPosition(Integer.valueOf(1));
		nav.setOrders(Integer.valueOf(4));
		nav.setUrl("/");
		navigationService.save(nav);
		
		nav.setName("关于我们");
		nav.setIsBlankTarget(Boolean.valueOf(false));
		nav.setPosition(Integer.valueOf(1));
		nav.setOrders(Integer.valueOf(5));
		nav.setUrl("/");
		
		navigationService.save(nav);
		
		nav.setName("产品中心");
		nav.setIsBlankTarget(Boolean.valueOf(false));
		nav.setPosition(Integer.valueOf(1));
		nav.setOrders(Integer.valueOf(6));
		nav.setUrl("/");
		
		navigationService.save(nav);
		
		nav.setName("生成设备");
		nav.setIsBlankTarget(Boolean.valueOf(false));
		nav.setPosition(Integer.valueOf(1));
		nav.setOrders(Integer.valueOf(7));
		nav.setUrl("/");
		
		navigationService.save(nav);
		
		nav.setName("联系我们");
		nav.setIsBlankTarget(Boolean.valueOf(false));
		nav.setPosition(Integer.valueOf(1));
		nav.setOrders(Integer.valueOf(8));
		nav.setUrl("/");
		
		navigationService.save(nav);
	}
}
