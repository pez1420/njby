package com.njby.tests;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Culture;
import com.njby.entity.search.SearchCulture;
import com.njby.service.CultureService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public class TestCulture {
	protected static CultureService cultureService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 cultureService = (CultureService)cxt.getBean("cultureServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	public void find_page() {
		 Pageable pageable = new Pageable(Integer.valueOf(1), Integer.valueOf(10));
		 SearchCulture searchCulture = new SearchCulture();
		 Page<Culture> page = cultureService.findPage(pageable, searchCulture);
		 List<Culture> Cultures = page.getContent(); 
		 for (Culture culture : Cultures) {
			 System.out.println(culture.getDetail());
		 }
	 }
	
	
	public void save() {
		Culture culture = new Culture();
		culture.setDetail("本公司专业制作不干胶标贴，可按照客户的不同需求定做印刷各种形状及规格的不干胶标签。对原材料的苛求让我们的产品质量能得到稳定的保证,大规模的采购能使我们的价格在同行业里成为皎皎者。");
		culture.setTitle("同行业里成为皎皎者");
		culture.setIcon("<i class=\"fa fa-language fa-2x pull-left\"></i>");
		this.cultureService.save(culture);
	}
	
	@Test
	public void findList() {
		Integer count = 4;
		List<Culture> cultures = this.cultureService.findList(count);
		if (cultures != null) {
			for (Culture culture : cultures) {
				System.out.println(culture.getTitle());
			}
		}
	}
}
