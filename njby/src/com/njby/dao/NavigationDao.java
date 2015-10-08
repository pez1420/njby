package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Navigation;
import com.njby.entity.search.SearchNavigation;
import com.njby.utils.Pageable;


public interface NavigationDao extends BaseDao<Navigation, String>{
	
	/***
	 *  根据导航位置返回导航列表
	 *  
	 * @param position
	 * @return
	 */
	public abstract List<Navigation> findList(Integer position);
	
	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchNavigation 搜索条件 
	 * @return
	 */
	public abstract List<Navigation> findPage(@Param("pageable")Pageable pageable, @Param("search")SearchNavigation searchNavigation);
		
}
