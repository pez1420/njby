package com.njby.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.LeaveMessage;
import com.njby.service.LeaveMessageService;

public class TestMessage {
	protected static LeaveMessageService leaveMessageService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 leaveMessageService = (LeaveMessageService)cxt.getBean("leaveMessageServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	@Test
	 public void save() {
		for (int i = 0; i < 1000; i++) {
			LeaveMessage message = new LeaveMessage();
			message.setName("李小龙");
			message.setTitle("您好4");
			message.setContent("贵公司所在地址");
			message.setPhone("15158064427");
			message.setIsReaded(Boolean.valueOf(false));
			message.setIsReplyed(Boolean.valueOf(false));
			message.setIsShowed(Boolean.valueOf(false));
			
			leaveMessageService.save(message);
		}
	}
}
