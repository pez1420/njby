package com.njby.tests;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Admin;
import com.njby.entity.Product;
import com.njby.entity.ProductType;
import com.njby.entity.Role;
import com.njby.entity.search.SearchAdmin;
import com.njby.entity.search.SearchProduct;
import com.njby.service.ProductService;
import com.njby.service.ProductTypeService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public class TestProduct {
	protected static ProductTypeService productTypeService;
	protected static ProductService productService;	
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 productTypeService = (ProductTypeService)cxt.getBean("productTypeServiceImpl");
		 productService = (ProductService)cxt.getBean("productServiceImpl");
		 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	
	 public void save_product() {
		 for (int i = 0; i < 1; i++) {
			 Product product = new Product();
			 //Date now = new Date();
			 //product.setCreateDate(now);
			 //product.setModifyDate(now);
			 product.setSn("2014-05-07");
			 product.setIsMarketable(Boolean.valueOf(true));
			 product.setName("南京不干胶1");
			 product.setPrice("20");
			 ProductType productType = new ProductType();
			 productType.setId("6b89865c1d4d11e5bf3b74e5432100f2");
			 product.setProductType(productType);
			 productService.save(product);
		 }
	 }
	
	 
	 public void save_product_type() {
		 for (int i = 0; i < 1; i++) {
			 ProductType productType = new ProductType();
			 Date now = new Date();
			 productType.setCreateDate(now);
			 productType.setModifyDate(now);
			 productType.setGrade(Integer.valueOf(0));
			 productType.setOrders(Integer.valueOf(2));
			 productType.setName("不干胶");
			 //productType.setSeoKeywords("印刷品");
			 productTypeService.save(productType);
		 }
	 }
	 
	 
	 public void save_product_type_son() {
		 for (int i = 0; i < 1; i++) {
			 ProductType productType = new ProductType();
			 //productType.setGrade(Integer.valueOf(1));
			 //productType.setOrders(Integer.valueOf(2));
			 productType.setName("印刷纸盒" + (i+1));

			 
			 String parentId = "6029965e1d8511e5932974e5432100f2";
			 
			 ProductType parent = productTypeService.find(parentId);
			 productType.setParent(parent);
			 
			if (parent != null) {
				productType.setGrade(Integer.valueOf(parent.getGrade().intValue() + 1));
				productType.setTreePath(parent.getTreePath() + parent.getId() + ProductType.TREE_PATH_SEPRATOR);
				
			} else {
				productType.setGrade(Integer.valueOf(0));
				productType.setTreePath(ProductType.TREE_PATH_SEPRATOR);
			}	
			
			productType.setOrders(parent.getOrders());
			
			productTypeService.save(productType);
		 }
	 }
	 
	 public void find_page() {
		 Pageable pageable = new Pageable(Integer.valueOf(1), Integer.valueOf(10));
		 SearchProduct searchProduct = new SearchProduct();
		 Page<Product> page = productService.findPage(pageable, searchProduct);
		 List<Product> products = page.getContent(); 
		 for (Product product : products) {
			 System.out.println(product.getProductType().getName());
		 }
	 }
	 
	 @Test
	 public void find_list() {
		 Integer count = 10;
		 List<Product> products = productService.findList(count);
		 if (products != null) {
			 for (Product product : products) {
				 System.out.println(product.getName());
			 }
		 }
	 }
}
