package com.njby.service;

import java.util.List;

import com.njby.entity.Navigation;
import com.njby.entity.search.SearchNavigation;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface NavigationService extends BaseService<Navigation, String>{
	
	public abstract List<Navigation> findList(Integer position);
	
	public abstract Page<Navigation> findPage(Pageable pageable, SearchNavigation searchNavigation);
	
		
}
