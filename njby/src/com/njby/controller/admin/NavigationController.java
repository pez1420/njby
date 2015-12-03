package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Navigation;
import com.njby.entity.search.SearchNavigation;
import com.njby.service.NavigationService;
import com.njby.service.ProductTypeService;
import com.njby.utils.Message;
import com.njby.utils.Pageable;

@Controller("adminNavigationController")
@RequestMapping({ "/admin/navigation" })
public class NavigationController extends BaseAdminController {

	@Resource
	private NavigationService navigationService;
	@Resource
	private ProductTypeService productTypeService;

	@RequestMapping(value = { "/add" }, method = { RequestMethod.GET })
	public String add(ModelMap model) {
		model.addAttribute("productTypeTree",
				this.productTypeService.findTree());
		
		return "/admin/content/navigation/navigation_add";
	}

	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public String save(Navigation navigation,
			RedirectAttributes redirectAttributes) {
		this.navigationService.save(navigation);

		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(Pageable pageable, 
			SearchNavigation searchNavigation,  ModelMap model) {
		model.addAttribute("page",
				this.navigationService.findPage(pageable, searchNavigation));
		model.addAttribute("search", searchNavigation);
		
		return "/admin/content/navigation/navigation_view";
	}

	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		model.addAttribute("navigation", this.navigationService.find(id));
		model.addAttribute("productTypeTree",
				this.productTypeService.findTree());
		
		return "/admin/content/navigation/navigation_edit";
	}

	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public String upate(Navigation navigation,
			RedirectAttributes redirectAttributes) {
		
		Navigation dbNavigation = this.navigationService.find(navigation.getId());
		if (dbNavigation == null) {
			return "/admin/common/error";
		}
		
		this.navigationService.update(navigation);
		
		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}
	
	@RequestMapping(value={"/delete"}, method={RequestMethod.POST})
	@ResponseBody
	public Message delete(String[] ids) {
		if (ids.length >= this.navigationService.count())
			return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);
		
		this.navigationService.remove(ids);
		return success;
	}
}
