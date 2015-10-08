package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Notice;
import com.njby.entity.search.SearchNotice;
import com.njby.utils.Pageable;

public interface NoticeDao extends BaseDao<Notice, String>{
	/**
	 * 按分页条件和查询参数对返回结果进行分页
	 * 
	 * @param pageable 前端分页数据
	 * @param searchAd 搜索条件 
	 * @return
	 */
	public abstract List<Notice> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchNotice searchNotice);
	
	/**
	 * 获取指定数量的通告记录
	 * 
	 * @param count 获取通告记录数目
	 * @return
	 */
	public abstract List<Notice> findList(Integer count);
}
