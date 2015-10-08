package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.AdPositionDao;
import com.njby.entity.AdPosition;
import com.njby.entity.search.SearchAdPosition;
import com.njby.service.AdPositionService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Service
public class AdPositionServiceImpl extends BaseServiceImpl<AdPosition, String> 
	implements AdPositionService{
	@Resource
	private AdPositionDao adPositionDao;
	
	@Resource
	public void setBaseDao(AdPositionDao adPositionDao) {
		super.setBaseDao(adPositionDao);
	}
	
	@Transactional(readOnly=true)
	public Page<AdPosition> findPage(Pageable pageable, SearchAdPosition searchAdPosition) {
		//分页并计算出总页数 
		List<AdPosition> adPositions = adPositionDao.findPage(pageable, searchAdPosition);
		Page<AdPosition> page = new Page<AdPosition>(adPositions, pageable);
		return page;
	}

}
