package com.njby.tests;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Notice;
import com.njby.service.NoticeService;

public class TestNotice {
	protected static NoticeService noticeService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 noticeService = (NoticeService)cxt.getBean("noticeServiceImpl");
		 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	@Test
	public void save() {
		Notice notice = new Notice();
		
		notice.setTitle("碧源礼品文化经营部华丽上线");
		notice.setContent("碧源礼品文化经营部华丽上线");
		notice.setIsPublication(Boolean.valueOf(true));
		notice.setHits(Integer.valueOf(0));
		noticeService.save(notice);
		
		notice.setTitle("吉野家被曝餐具不消毒 波司登等羊绒衫不含羊绒");
		notice.setContent("吉野家被曝餐具不消毒 波司登等羊绒衫不含羊绒");
		notice.setIsPublication(Boolean.valueOf(true));
		notice.setHits(Integer.valueOf(0));
		
		noticeService.save(notice);		
		
	}
	
	
	public void finList() {
		List<Notice> notices = this.noticeService.findList(1);
		for (Notice notice : notices) {
			System.out.println(notice.getTitle());
		}
	}
}
