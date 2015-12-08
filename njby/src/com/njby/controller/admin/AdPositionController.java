package com.njby.controller.admin;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.AdPosition;
import com.njby.entity.search.SearchAdPosition;
import com.njby.service.AdPositionService;
import com.njby.utils.Pageable;

@Controller("adminAdPositionController")
@RequestMapping({ "/admin/ad_position" })
public class AdPositionController extends BaseAdminController {
	@Resource
	private AdPositionService adPositionService;

	@RequestMapping(value = { "/add" }, method = { RequestMethod.GET })
	public String add(ModelMap model) {
		return "/admin/content/adposition/adposition_add";
	}

	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public String save(AdPosition adPosition,
			RedirectAttributes redirectAttributes) {
		this.adPositionService.save(adPosition);

		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		AdPosition adPosition = this.adPositionService.find(id);
		model.addAttribute("adPosition", adPosition);
		
		return "/admin/content/adposition/adposition_edit";
	}

	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public String update(@Valid AdPosition adPosition, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "/admin/common/error";
		}

		this.adPositionService.update(adPosition);

		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(Pageable pageable, SearchAdPosition searchAdPosition,
			ModelMap model) {
		model.addAttribute("page",
				this.adPositionService.findPage(pageable, searchAdPosition));
		return "/admin/content/adposition/adposition_view";
	}

}
