package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njby.entity.LeaveMessage;
import com.njby.entity.search.SearchLeaveMessage;
import com.njby.service.LeaveMessageService;
import com.njby.utils.Message;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Controller("adminLeaveMessageController")
@RequestMapping({"/admin/leave_message"})
public class LeaveMessageController extends BaseAdminController{
	@Resource
	private LeaveMessageService leaveMessageService;
	
	  @RequestMapping(value={"/list"}, method={RequestMethod.GET}, produces = "text/html;charset=UTF-8")
	  public String list(Pageable pageable, SearchLeaveMessage searchLeaveMessage, ModelMap model)
	  {
		  //Page<LeaveMessage> page = this.leaveMessageService.findPage(pageable, searchLeaveMessage);
		  model.addAttribute("page", this.leaveMessageService.findPage(pageable, searchLeaveMessage));
		  System.out.println(searchLeaveMessage.getContent());
		  model.addAttribute("search", searchLeaveMessage);
		  return "/admin/contactus/leave_message/leave_message_view";
	  }	 
	  
		@RequestMapping(value = { "/delete" }, method = {RequestMethod.POST })
		@ResponseBody
		public Message delete(String[] ids) {
			//不能够全部删除,至少保留一项
			if (ids.length >= this.leaveMessageService.count()) {
				return Message.error("admin.common.deleteAllNotAllowed",
						new Object[0]);
			}
			this.leaveMessageService.remove(ids);
			return success;
		}
}
