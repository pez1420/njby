package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.entity.Equipment;
import com.njby.entity.Equipment;
import com.njby.entity.search.SearchEquipment;
import com.njby.service.impl.BaseServiceImpl;
import com.njby.service.EquipmentService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;
import com.njby.dao.EquipmentDao;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-11
 */
@Service
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment, String> implements EquipmentService{

    @Resource
    private EquipmentDao equipmentDao;

    @Resource
    public void setBaseDao(EquipmentDao equipmentDao){
        super.setBaseDao(equipmentDao);
    }

    @Transactional(readOnly=true)
	public Page<Equipment> findPage(Pageable pageable,
			SearchEquipment searchEquipment) {
		// 分页并计算出总页数
		List<Equipment> equipments = equipmentDao.findPage(pageable, searchEquipment);
		Page<Equipment> page = new Page<Equipment>(equipments, pageable);
		return page;
	}

	 @Transactional(readOnly=true)
	public List<Equipment> findList(Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

}