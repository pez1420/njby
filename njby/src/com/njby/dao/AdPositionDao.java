package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.AdPosition;
import com.njby.entity.search.SearchAdPosition;
import com.njby.utils.Pageable;

public interface AdPositionDao extends BaseDao<AdPosition, String>{
	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchAdPosition 搜索条件 
	 * @return
	 */
	public abstract List<AdPosition> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchAdPosition searchAdPosition);
}
