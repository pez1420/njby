package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.LeaveMessageDao;
import com.njby.entity.LeaveMessage;
import com.njby.entity.search.SearchLeaveMessage;
import com.njby.service.LeaveMessageService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Service
public class LeaveMessageServiceImpl extends BaseServiceImpl<LeaveMessage, String> 
	implements LeaveMessageService{

	@Resource
	private LeaveMessageDao leaveMessageDao;
	
	@Resource
	public void setBaseDao(LeaveMessageDao leaveMessageDao) {
		super.setBaseDao(leaveMessageDao);
	}
	
	@Transactional(readOnly=true)
	public Page<LeaveMessage> findPage(Pageable pageable,
			SearchLeaveMessage searchLeaveMessage) {
		//分页并计算出总页数 
		List<LeaveMessage> leaveMessages = leaveMessageDao.findPage(pageable, searchLeaveMessage);
		Page<LeaveMessage> page = new Page<LeaveMessage>(leaveMessages, pageable);
		return page;
	}

}
