package com.njby.service;

import com.njby.entity.LeaveMessage;
import com.njby.entity.search.SearchLeaveMessage;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface LeaveMessageService extends BaseService<LeaveMessage, String>{
	public abstract Page<LeaveMessage> findPage(Pageable pageable, 
			SearchLeaveMessage searchLeaveMessage);
}
