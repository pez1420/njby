package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.dao.BaseDao;
import com.njby.entity.Equipment;
import com.njby.entity.search.SearchEquipment;
import com.njby.utils.Pageable;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-11
 */
public interface EquipmentDao extends BaseDao <Equipment, String> {

	/***
	 * 
	 * @param pageable
	 * @param searchEquipment
	 * @return
	 */
	public abstract List<Equipment> findPage(
			@Param("pageable") Pageable pageable,
			@Param("search") SearchEquipment searchEquipment);
	
	/***
	 * 返回设备列表
	 * 
	 * @param count
	 * @return
	 */
	public abstract List<Equipment> findList(Integer count);
}