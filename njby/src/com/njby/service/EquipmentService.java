package com.njby.service;

import java.util.List;

import com.njby.service.BaseService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;
import com.njby.entity.Equipment;
import com.njby.entity.search.SearchEquipment;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-11
 */
public interface EquipmentService extends BaseService<Equipment, String>{
	
	public abstract Page<Equipment> findPage(Pageable pageable,
			SearchEquipment searchEquipment);
	
	public abstract List<Equipment> findList(Integer count);
}