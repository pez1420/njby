package com.njby.tests;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Equipment;
import com.njby.entity.search.SearchEquipment;
import com.njby.service.EquipmentService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public class TestEquipment {
	protected static EquipmentService equipmentService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
			 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
			 equipmentService = (EquipmentService)cxt.getBean("equipmentServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }	
	
	@Test
	public void find_page() {
		 Pageable pageable = new Pageable(Integer.valueOf(1), Integer.valueOf(10));
		 //SearchEquipment searchEquipment = new SearchEquipment();
		 Page<Equipment> page = equipmentService.findPage(pageable, null);
		 List<Equipment> Equipments = page.getContent(); 
		 for (Equipment e : Equipments) {
			 System.out.println(e.getThumbnailImage());
		 }
	 }
}
