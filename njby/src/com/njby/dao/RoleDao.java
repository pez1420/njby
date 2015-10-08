package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Role;
import com.njby.entity.RoleAuthority;
import com.njby.entity.search.SearchRole;
import com.njby.utils.Pageable;


public interface RoleDao extends BaseDao<Role, String>{

	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchRole 搜索条件 
	 * @return
	 */
	public abstract List<Role> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchRole searchRole);
	
	/**
	 * 返回所有角色
	 * @return
	 */
	public List<Role> findAll();
	
	/***
	 * 
	 * @param role
	 * @return
	 */
	public List<Role> findRoleAdmin(Role role);

	/***
	 * 
	 * @param role
	 * @return
	 */
	public List<RoleAuthority> findRoleAuthorities(Role role);
	
	/***
	 * 
	 * @param roleAuthority
	 */
	public void saveRoleAuthorities(RoleAuthority roleAuthority);
	
	/***
	 * 
	 * @param roleAuthority
	 */
	public void deleteRoleAuthorities(RoleAuthority roleAuthority);
	
	/***
	 * 根据主键列表返回角色列表
	 * 
	 * @param ids 主键数组
	 * 
	 * @return 返回角色列表
	 */
	public  List<Role> findRolesByIds(String[] ids); //@Param(value = "roleIds")
}

