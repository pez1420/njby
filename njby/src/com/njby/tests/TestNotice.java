package com.njby.tests;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
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
	
	
	public void fileNameUtils() {
		String srcImageRealPath = "/a/b/2010/xxx.jsp";
		String targetPath = FilenameUtils.getPath(srcImageRealPath);
		//String source = FilenameUtils.getExtension("abc.jpg");
		String prefix = FilenameUtils.getBaseName("a8db4410-05e5-4dfa-8217-eb885a104af3-source.jpg");
		System.out.println(prefix);
	}
	
	
	public void update() {
		Notice notice = new Notice();
		notice.setId("e6e1b1e294d011e5ba1174e5432100f2");
		notice.setContent("测试1");
		notice.setAuthor("鲁友炳");
		noticeService.update(notice);
	}
	
	@Test
	public void find() {
		Notice notice = this.noticeService.find("e6e1b1e294d011e5ba1174e5432100f2");
		System.out.println();
	}
}
