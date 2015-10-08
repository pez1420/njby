package com.njby.service;

import java.util.List;

import com.njby.entity.Admin;
import com.njby.entity.search.SearchAdmin;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


public abstract interface AdminService extends BaseService<Admin, String> {
	
	public abstract boolean usernameExists(String username); 

	public abstract Admin findByUsername(String username);
	
	public abstract Page<Admin> findPage(Pageable pageable, SearchAdmin searchAdmin);
	
	public abstract List<String> findAuthorities(String id);
	
	public abstract boolean isAuthenticated();

	public abstract Admin getCurrent();

	public abstract String getCurrentUsername();
	
	public abstract void updateWithRole(Admin admin); 
	
	public abstract Admin findAdminRoles(String id);	
}