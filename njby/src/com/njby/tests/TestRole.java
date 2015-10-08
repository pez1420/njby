package com.njby.tests;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.njby.entity.Role;
import com.njby.service.RoleService;

public class TestRole {
	protected static RoleService roleService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
				 "applicationContext-mybatis.xml"});
		 roleService = (RoleService)cxt.getBean("roleServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }	
	
	@Test
	 public void save() {
		 Role role = new Role();
		 Date now = new Date();
		 role.setCreateDate(now);
		 role.setModifyDate(now);
		 role.setIsSystem(Boolean.valueOf(true));
		 role.setName("超级角色1");
		 role.setDescription("拥有所有权限1");
		 roleService.save(role);
	 }
	 
	 public void find() {
		 String id = "a41c5c74e59811e4b6770ca827cc8740";
		 Role role = roleService.find(id);
		 System.out.println(role.getName());
	 }

	 
	 public void findAll() {
		 List<Role> roles = roleService.findAll();
		 if (roles != null) {
			 for (Role role : roles) 
			 System.out.println(role.getName());
		 }
	 }
	 
	 
	 public void remove() {
		 String id = "a41c5c74e59811e4b6770ca827cc8740";
		 roleService.remove(id);

	 }
}
