package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Navigation;
import com.njby.entity.search.SearchNavigation;
import com.njby.service.NavigationService;
import com.njby.service.ProductTypeService;
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
		// model.addAttribute("positions", Navigation.Position.values());
		// model.addAttribute("articleCategoryTree", this.IIIllllI.findTree());
		model.addAttribute("productCategoryTree",
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
		return "/admin/content/navigation/navigation_view";
	}

}
