package com.njby.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Ad;
import com.njby.entity.AdPosition;
import com.njby.service.AdPositionService;
import com.njby.service.AdService;

public class TestAdvetise {
	protected static AdPositionService adPositionService;
	protected static AdService adService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 adPositionService = (AdPositionService)cxt.getBean("adPositionServiceImpl");
		 adService 		   = (AdService)cxt.getBean("adServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }	
	
	
	public void save_adposition() {
		AdPosition adPosition = new AdPosition();
		adPosition.setWidth(Integer.valueOf(200));
		adPosition.setHeight(Integer.valueOf(200));
		adPosition.setName("首页轮播广告");
		adPosition.setTemplate("mubanneirongggjlfjajflajfljalfjalfjalfjlajfladjfld");
		
		adPositionService.save(adPosition);
		
	}
	
	@Test
	public void save_ad() {
		Ad ad = new Ad();
		ad.setOrders(Integer.valueOf(6));
		ad.setPath("http://storage.shopxx.net/demo-image/3.0/ad/index_right.jpg");
		ad.setContent("轮播图片1");
		ad.setTitle("春季新品");
		ad.setAdType(Integer.valueOf(1));
		ad.setAdPosition(adPositionService.find("fb0580b01b4411e5944774e5432100f2"));
		
		adService.save(ad);
	}
	
}
