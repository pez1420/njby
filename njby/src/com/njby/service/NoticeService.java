package com.njby.service;

import java.util.List;

import com.njby.entity.Notice;
import com.njby.entity.search.SearchNotice;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface NoticeService extends BaseService<Notice, String> {
	
	public abstract Page<Notice> findPage(Pageable pageable, SearchNotice searchNotice);
	
	public abstract List<Notice> findList(Integer count);
}
