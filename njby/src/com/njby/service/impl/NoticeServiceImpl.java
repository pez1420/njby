package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.NoticeDao;
import com.njby.entity.Notice;
import com.njby.entity.search.SearchNotice;
import com.njby.service.NoticeService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice, String> 
	implements NoticeService{
	
	@Resource
	private NoticeDao noticeDao;
	
	@Resource
	public void setBaseDao(NoticeDao noticeDao) {
		super.setBaseDao(noticeDao);
	}
	
	@Transactional(readOnly=true)
	public Page<Notice> findPage(Pageable pageable, SearchNotice searchNotice) {
		List<Notice> notices = this.noticeDao.findPage(pageable, searchNotice);
		Page<Notice> page = new Page<Notice>(notices, pageable);
		return page;
	}
	
	@Transactional(readOnly=true)
	public List<Notice> findList(Integer count) {
		return this.noticeDao.findList(count);
	}

}
