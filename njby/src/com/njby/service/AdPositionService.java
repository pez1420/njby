package com.njby.service;

import com.njby.entity.AdPosition;
import com.njby.entity.search.SearchAdPosition;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface AdPositionService extends BaseService<AdPosition, String> {

	public abstract Page<AdPosition> findPage(Pageable pageable,
			SearchAdPosition searchAdPosition);

}
