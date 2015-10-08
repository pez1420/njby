package com.njby.tests;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njby.entity.Admin;
import com.njby.entity.Role;
import com.njby.entity.search.SearchAdmin;
import com.njby.service.AdminService;
import com.njby.service.RoleService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;



public class TestAdminer {
	protected static AdminService adminService;
	protected static RoleService roleService;
	
	@BeforeClass
	 public static void setUpBeforeClass() throws Exception {
		 try {
			 ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml",
					 "applicationContext-mybatis.xml"});
			 adminService = (AdminService)cxt.getBean("adminServiceImpl");
			 roleService = (RoleService)cxt.getBean("roleServiceImpl");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }	

	
	 public void save() {
		 
		 Admin admin = new Admin();
		 admin.setEmail("ws@163.com");
		 admin.setIsEnabled(Boolean.valueOf(true));
		 admin.setIsLocked(Boolean.valueOf(false));
		 admin.setUsername("ws");
		 admin.setPassword("22222222222");
		 
		 Role role1 = new Role();
		 role1.setId("a07c4a0719bb11e5bc5474e5432100f2");
		 admin.getRoles().add(role1);
		 Role role2 = new Role();
		 role2.setId("b07c4a0719bb22e5bc5474e5432100f2");
		 admin.getRoles().add(role2);
		 
		 adminService.save(admin);
		 
		 System.out.println(admin.getEmail());
	 }	 
	 
	 
	 public void remove() {
		 String adminId = "a7048bbf294411e594ec74e5432100f2";
		 adminService.remove(adminId);
	 }
	 

	 
	 public void removes() {
		 String []ids = new String[]{"f4a2cc2927ed11e5aa6800ff624f02c5", 
				 "7b32d72c27ed11e5aa6800ff624f02c5"};
		 adminService.remove(ids); 
	 }
	 
	 public void findPage() {
		 Pageable pageable = new Pageable(Integer.valueOf(1), Integer.valueOf(10));
		 SearchAdmin searchAdmin = new SearchAdmin();
		 Page<Admin> page = adminService.findPage(pageable, searchAdmin);
		 List<Admin> adminers = page.getContent(); 
		 for (Admin adminer : adminers) {
			 System.out.println(adminer.getId());
			 List<Role> roles = adminer.getRoles();
			 if (roles != null && !roles.isEmpty()) {
				 for (Role role : roles) {
					 System.out.println(role.getName());
				 }
			 } else {
				 System.out.println("角色空");
			 }

		 }
	 }
	 
	 
	 public void findPageWithCache() {
		 Pageable pageable = new Pageable(Integer.valueOf(1), Integer.valueOf(10));
		 SearchAdmin searchAdmin = new SearchAdmin();
		 Page<Admin> page = adminService.findPage(pageable, searchAdmin);
		 List<Admin> adminers = page.getContent(); 
		 System.out.println(adminers.size());
		 
		 page = adminService.findPage(pageable, searchAdmin);
		 adminers = page.getContent(); 
		 System.out.println(adminers.size());
		 
	 }
	 
	
	 public void update() {
		 Admin admin = new Admin();
		 admin.setId("6f8a149f294511e594ec74e5432100f2");
		 admin.setUsername("user100");
		 admin.setPassword("dddddddddddd");
		 admin.setEmail("dddd@163.com");
		 admin.setIsEnabled(Boolean.valueOf(true));
		 
		 Role role1 = new Role();
		 role1.setId("a07c4a0719bb11e5bc5474e5432100f2");
		 admin.getRoles().add(role1);
		 
		 adminService.updateWithRole(admin);
	 }
	 
	
	@Test
	public void find() {
		 String username = "lyb";
		 Admin admin = this.adminService.findByUsername(username);
		 System.out.println(admin.getUsername());
	 }
	 
	 
}
