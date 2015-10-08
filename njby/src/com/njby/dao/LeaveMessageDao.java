package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.LeaveMessage;
import com.njby.entity.search.SearchLeaveMessage;
import com.njby.utils.Pageable;

public interface LeaveMessageDao extends BaseDao<LeaveMessage, String>{
	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchAd 搜索条件 
	 * @return
	 */
	public abstract List<LeaveMessage> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchLeaveMessage searchLeaveMessage);
}
