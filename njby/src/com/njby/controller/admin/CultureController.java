package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njby.entity.search.SearchAdmin;
import com.njby.entity.search.SearchCulture;
import com.njby.service.CultureService;
import com.njby.utils.Pageable;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-05
 */
@Controller("adminCultureController")
@RequestMapping({ "/admin/culture" })
public class CultureController extends BaseAdminController {

	@Resource
	private CultureService cultureService;
	
	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(Pageable pageable, SearchCulture searchCulture,
			ModelMap model) {
		model.addAttribute("page", cultureService.findPage(pageable, searchCulture));
		model.addAttribute("search", searchCulture);
		return "/admin/firm/culture/culture_view";
	}
}