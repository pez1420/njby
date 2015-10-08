package com.njby.service;

import com.njby.entity.Log;
import com.njby.entity.search.SearchLog;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface LogService extends BaseService<Log, String> {
	
	public abstract void clear();
	
	public abstract Page<Log> findPage(Pageable pageable, SearchLog searchLog);
	
}
