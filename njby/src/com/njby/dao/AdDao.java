package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Ad;
import com.njby.entity.search.SearchAd;
import com.njby.utils.Pageable;

public interface AdDao extends BaseDao<Ad, String>{
	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchAd 搜索条件 
	 * @return
	 */
	public abstract List<Ad> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchAd searchAd);
	
}
