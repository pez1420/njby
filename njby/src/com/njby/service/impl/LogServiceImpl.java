package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.LogDao;
import com.njby.entity.Log;
import com.njby.entity.search.SearchLog;
import com.njby.service.LogService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Service
public class LogServiceImpl extends BaseServiceImpl<Log, String>  
	implements LogService{
	
	@Resource
	private LogDao logDao;
		  
	@Resource
	public void setBaseDao(LogDao logDao) {
		super.setBaseDao(logDao);
	}
	
	@Transactional
	public void clear() {
		this.logDao.removeAll();
	}

	@Transactional(readOnly=true)
	public Page<Log> findPage(Pageable pageable, SearchLog searchLog) {
		//分页并计算出总页数 
		List<Log> logs = logDao.findPage(pageable, searchLog);
		Page<Log> page = new Page<Log>(logs, pageable);
		return page;
	}
}
