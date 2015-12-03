package com.njby.controller.admin;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Notice;
import com.njby.entity.search.SearchNotice;
import com.njby.service.NoticeService;
import com.njby.utils.Message;
import com.njby.utils.Pageable;

@Controller("adminNoticeController")
@RequestMapping({ "/admin/notice" })
public class NoticeController extends BaseAdminController {
	@Resource
	private NoticeService noticeService;

	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(Pageable pageable, SearchNotice searchNotice,
			ModelMap model) {
		model.addAttribute("page",
				noticeService.findPage(pageable, searchNotice));
		model.addAttribute("search", searchNotice);
		return "/admin/corp_index/notice/notice_view";
	}

	@RequestMapping(value = { "/add" }, method = { RequestMethod.GET })
	public String add(ModelMap model) {
		return "/admin/corp_index/notice/notice_add";
	}

	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public String save(@Valid Notice notice, BindingResult result,
			RedirectAttributes redirectAttributes, ModelMap model) {

		if (result.hasErrors()) {
			return "/admin/error";
		}

		if (notice.getHits() == null)
			notice.setHits(Integer.valueOf(0));

		this.noticeService.save(notice);
		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		model.addAttribute("notice", this.noticeService.find(id));
		return "/admin/corp_index/notice/notice_edit";
	}

	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public String update(@Valid Notice notice, BindingResult result,
			RedirectAttributes redirectAttributes, ModelMap model) {
		
		if (result.hasErrors()) {
			return "/admin/error";
		}
		
		if (notice.getHits() == null)
			notice.setHits(Integer.valueOf(0));
		
		this.noticeService.update(notice);
		
		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/delete" }, method = { RequestMethod.POST })
	@ResponseBody
	public Message delete(String[] ids) {
		if (ids.length >= this.noticeService.count())
			return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);

		this.noticeService.remove(ids);
		return success;
	}
	
	@RequestMapping(value = { "/detail" }, method = { RequestMethod.POST })
	@ResponseBody
	public String detail(String id) {
		return null;
		
	}

}
