package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.dao.BaseDao;
import com.njby.entity.Culture;
import com.njby.entity.search.SearchCulture;
import com.njby.utils.Pageable;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-05
 */
public interface CultureDao extends BaseDao<Culture, String> {

	/***
	 * 
	 * @param pageable
	 * @param searchCulture
	 * @return
	 */
	public abstract List<Culture> findPage(
			@Param("pageable") Pageable pageable,
			@Param("search") SearchCulture searchCulture);
	
	/***
	 * 
	 * @param count
	 * @return
	 */
	public abstract List<Culture> findList(Integer count);
}