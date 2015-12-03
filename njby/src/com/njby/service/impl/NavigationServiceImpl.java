package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.NavigationDao;
import com.njby.entity.Navigation;
import com.njby.entity.search.SearchNavigation;
import com.njby.service.NavigationService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Service
public class NavigationServiceImpl extends BaseServiceImpl<Navigation, String>
	implements NavigationService{
	
	@Resource
	private NavigationDao navigationDao;
	
	@Resource
	public void setBaseDao(NavigationDao navigationDao) {
		super.setBaseDao(navigationDao);
	}
	
	@Transactional(readOnly=true)
	public List<Navigation> findList(Integer position) {
		return this.navigationDao.findList(position);
	}

	@Transactional(readOnly=true)
	public Page<Navigation> findPage(Pageable pageable,
			SearchNavigation searchNavigation) {
		//分页并计算出总页数 
		List<Navigation> navigations = navigationDao.findPage(pageable, searchNavigation);
		Page<Navigation> page = new Page<Navigation>(navigations, pageable);
		return page;
	}

}
