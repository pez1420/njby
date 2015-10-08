package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.service.CacheService;

@Controller("adminCacheController")
@RequestMapping({ "/admin/cache" })
public class CacheController extends BaseAdminController {
	@Resource(name = "cacheServiceImpl")
	private CacheService cacheService;

	@RequestMapping(value = { "/clear" }, method = { RequestMethod.GET })
	public String clear(ModelMap model) {
		Long totalMemory = null;
		Long maxMemory = null;
		Long freeMemory = null;
		
		try {
			totalMemory = Long
					.valueOf(Runtime.getRuntime().totalMemory() / 1024L / 1024L);
			maxMemory = Long
					.valueOf(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
			freeMemory = Long
					.valueOf(Runtime.getRuntime().freeMemory() / 1024L / 1024L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("totalMemory", totalMemory);
		model.addAttribute("maxMemory", maxMemory);
		model.addAttribute("freeMemory", freeMemory);
		model.addAttribute("cacheSize",
				Integer.valueOf(this.cacheService.getCacheSize()));
		model.addAttribute("diskStorePath",
				this.cacheService.getDiskStorePath());
		return "/admin/content/cache/cache_clear";
	}

	@RequestMapping(value = { "/clear" }, method = { RequestMethod.POST })
	public String clear(RedirectAttributes redirectAttributes) {
		this.cacheService.clear();
		addFlashAttribute(redirectAttributes, success);
		return "redirect:clear.jhtml";
	}
}
