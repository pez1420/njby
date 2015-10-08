package com.njby.service;

import java.util.List;

import com.njby.entity.Role;
import com.njby.entity.search.SearchRole;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


public interface RoleService extends BaseService<Role, String>{
	
	public List<Role> findAll();
	
	public void update(Role role, String... authorities);
	
	public abstract Page<Role> findPage(Pageable pageable, SearchRole searchRole);
	
	public void save(Role role, String... authorities);
	
	public  List<Role> findRolesByIds(String[] ids);
}
