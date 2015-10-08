package com.njby.tests;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Catalog;
import com.njby.service.CatalogService;

public class TestCatalog {
	protected static CatalogService catalogService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
			 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
			 catalogService = (CatalogService)cxt.getBean("catalogServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }	
	
	
	public void findRoots() {
		List<Catalog> catalogs = catalogService.findRoots(Integer.valueOf(0));
		for (Catalog catalog : catalogs) {
			System.out.println(catalog);
		}
	}
	
	@Test
	public void findParents_1() {
		Catalog catalog = new Catalog();
		catalog.setId("ef66a88df2fe11e486103ab2cbe319cd");
		catalog.setName("连衣裙");
		catalog.setGrade(Integer.valueOf(1));
		catalog.setTreePath(",3bd38d8afad211e4a4c9e438cb534e3f,");
		
		List<Catalog> catalogs = catalogService.findParents(catalog, Integer.valueOf(0));
		for (Catalog e : catalogs) {
			System.out.println(e);
		}
	}

	
	
	public void findParents_2() {
		Catalog catalog = new Catalog();
		catalog.setId("df6cffb4f2fe11e486103ab2cbe519cd");
		catalog.setName("gucci连衣裙");
		catalog.setGrade(Integer.valueOf(2));
		catalog.setTreePath(",3bd38d8afad211e4a4c9e438cb534e3f,ef66a88df2fe11e486103ab2cbe319cd,");
		
		List<Catalog> catalogs = catalogService.findParents(catalog, Integer.valueOf(0));
		for (Catalog e : catalogs) {
			System.out.println(e);
		}
	}
	
	public void findChilds() {
		Catalog catalog = new Catalog();
		catalog.setId("3bd38d8afad211e4a4c9e438cb534e3f");
		catalog.setName("时尚女装");
		catalog.setGrade(Integer.valueOf(0));
		catalog.setTreePath(",");
		
		List<Catalog> childs = catalogService.findChildrens(catalog, Integer.valueOf(0));
		for (Catalog e : childs) {
			System.out.println(e);
		}
	}
	
	
	public void findTree() {
		List<Catalog> catalogs = catalogService.findTree();
		for (Catalog e : catalogs) {
			System.out.println(e);
		}
		
		catalogs = catalogService.findTree();
		for (Catalog e : catalogs) {
			System.out.println(e);
		}
		
	}
	
	
	private Catalog getParent(String parentId) {
		return catalogService.find(parentId);
	}
	
	
	
	public void save() {
		String TREE_PATH_SEPRATOR = ",";
		
		Catalog catalog = new Catalog();
		
		String parentId = "ef66a88df2fe11e486103ab2cbe319cd"; // 
		Catalog parent = getParent(parentId);
		
		catalog.setParent(parent);
		catalog.setName("Semir连衣裙");
		
		if (parent != null) {
			catalog.setGrade(Integer.valueOf(parent.getGrade().intValue() + 1));
			catalog.setTreePath(parent.getTreePath() + parent.getId() + TREE_PATH_SEPRATOR);
		} else {
			catalog.setGrade(Integer.valueOf(0));
			catalog.setTreePath(TREE_PATH_SEPRATOR);
		}
	
		catalogService.save(catalog);
		
	}
	
	
	public void update() {
		
	}
	
}
