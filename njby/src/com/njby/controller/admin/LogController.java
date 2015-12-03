package com.njby.controller.admin;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njby.entity.search.SearchLog;
import com.njby.service.LogService;
import com.njby.utils.Message;
import com.njby.utils.Pageable;
import com.ruijie.framework.kyo.session.serialization.hessian.HessianSerialization;

@Controller("adminLogController")
@RequestMapping({ "/admin/log" })
public class LogController extends BaseAdminController {
	
	private static final Logger logger = Logger
			.getLogger(LogController.class);
	
	@Resource
	private LogService logService;

	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(Pageable pageable, SearchLog searchLog, ModelMap model) {
		model.addAttribute("page",
				this.logService.findPage(pageable, searchLog));
		
		logger.debug("tomcat集群测试log列表");
		
		return "/admin/system_set/log/log_view";
	}
	
	@RequestMapping(value={"/delete"}, method={RequestMethod.POST})
	@ResponseBody
	public Message delete(String[] ids) {
		if (ids.length >= this.logService.count())
			return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);
		
		this.logService.remove(ids);
		return success;
	}
}
