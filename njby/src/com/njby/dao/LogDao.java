package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Log;
import com.njby.entity.search.SearchLog;
import com.njby.utils.Pageable;

public interface LogDao extends BaseDao<Log, String> {
	/**
	 * 删除所有日志信息
	 */
	public abstract void removeAll();
	
	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchAdminer 搜索条件 
	 * @return
	 */
	public abstract List<Log> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchLog searchLog);
		
}
