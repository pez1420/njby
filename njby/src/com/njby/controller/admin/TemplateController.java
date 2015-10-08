package com.njby.controller.admin;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.njby.service.TemplateService;
import com.system.Template;

@Controller("adminTemplateController")
@RequestMapping({ "/admin/template" })
public class TemplateController extends BaseAdminController {
	@Resource(name = "freeMarkerConfigurer")
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Resource(name = "templateServiceImpl")
	private TemplateService templateService;

	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		if (StringUtils.isEmpty(id)) {
			return "/admin/common/error";
		}
		model.addAttribute("template", this.templateService.get(id));
		String content = this.templateService.read(id);
		model.addAttribute("content", this.templateService.read(id));
		return "/admin/content/template/template_edit";
	}

	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public String update(String id, String content,
			RedirectAttributes redirectAttributes) {
		if ((StringUtils.isEmpty(id)) || (content == null)) {
			return "/admin/common/error";
		}
		this.templateService.write(id, content);
		this.freeMarkerConfigurer.getConfiguration().clearTemplateCache();
		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(ModelMap model) {
		model.addAttribute("templates", this.templateService.getList(Integer.valueOf(0)));
		return "/admin/content/template/template_list";
	}
}
