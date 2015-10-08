package com.njby.service;

import java.util.List;

import com.njby.service.BaseService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;
import com.njby.entity.Culture;
import com.njby.entity.search.SearchCulture;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-05
 */
public interface CultureService extends BaseService<Culture, String> {

	public abstract Page<Culture> findPage(Pageable pageable,
			SearchCulture searchCulture);
	
	public abstract List<Culture> findList(Integer count);

}