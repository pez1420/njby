package com.njby.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Admin;
import com.njby.entity.AdminRoleLink;
import com.njby.entity.search.SearchAdmin;
import com.njby.utils.Pageable;

public interface AdminDao extends BaseDao<Admin, String>{

	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchAdminer 搜索条件 
	 * @return
	 */
	public abstract List<Admin> findPage(@Param("pageable")Pageable pageable, @Param("search")SearchAdmin searchAdmin);
	
	/***
	 *  检测用户名是否存在
	 *  
	 * @param username 用户名
	 * @return   
	 */
	public abstract long usernameExists(String username); 
	
	
	/**
	 * 保存AdminRole关联关系
	 * 
	 * @param adminRoleLink  关联实体
	 */
	public abstract void saveRelativity(AdminRoleLink adminRoleLink);
	
	/***
	 * 由admin主键ID删除AdminRole关联关系
	 * 
	 * @param id
	 */
	public abstract void removeRelativity(AdminRoleLink adminRoleLink);
	
	
	/***
	 * 根据admin表中的id查询用户和角色信息
	 * 
	 * @param id admin主键
	 * @return
	 */
	public abstract Admin findAdminRole(String id);

	
	/***
	 * 根据admin表中的id返回关联表信息
	 * 
	 * @param id admin主键
	 * @return
	 */
	public abstract Admin findAdminRoles(String id);
	
	/***
	 * 返回管理员所有Authorities
	 * 
	 * @param id 管理员id
	 * 
	 * @return Authorities列表
	 */
	public List<String> findAuthorities(String id);

	/**
	 * 根据用户名返回 Admin
	 * 
	 * @param username
	 * @return
	 */
	public abstract Admin findByUsername(String username);
}
