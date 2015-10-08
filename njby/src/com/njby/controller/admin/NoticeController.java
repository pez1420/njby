package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njby.entity.search.SearchNotice;
import com.njby.service.NoticeService;
import com.njby.utils.Pageable;

@Controller("adminNoticeController")
@RequestMapping({ "/admin/notice" })
public class NoticeController extends BaseAdminController {
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping(value = {"/list"}, method = {RequestMethod.GET})
	public String list(Pageable pageable, SearchNotice searchNotice, ModelMap model) {
		model.addAttribute("page", noticeService.findPage(pageable, searchNotice));
		model.addAttribute("search", searchNotice);
		return "/admin/corp_index/notice/notice_view";
	}
}
