package com.njby.service;

import com.njby.entity.Ad;
import com.njby.entity.search.SearchAd;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface AdService extends BaseService<Ad, String>{

	public abstract Page<Ad> findPage(Pageable pageable, SearchAd searchAd);
	
}
