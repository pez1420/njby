package com.njby.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Role;
import com.njby.entity.search.SearchRole;
import com.njby.service.RoleService;
import com.njby.utils.Pageable;


@Controller("adminRoleController")
@RequestMapping({"/admin/role"})
public class RoleController extends BaseAdminController{

	@Resource
	private RoleService roleService;

	@RequestMapping(value = {"/list"}, method = {RequestMethod.GET})
	public String list(Pageable pageable, SearchRole searchRole, ModelMap model) {
		model.addAttribute("page", roleService.findPage(pageable, searchRole));
		model.addAttribute("search", searchRole);
		return "/admin/system_set/role/role_view";
	}
	
	@RequestMapping(value={"/add"}, method={RequestMethod.GET})
	public String add() {
		return "/admin/system_set/role/role_add";
	}
	
	@RequestMapping(value={"/save"}, method={RequestMethod.POST})
	public String save(Role role, HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		String[] authorities = request.getParameterValues("authorities");
		role.setIsSystem(Boolean.valueOf(false));
		this.roleService.save(role, authorities);
		addFlashAttribute(redirectAttributes, success);
		
		return "redirect:list.jhtml";
	}
	
	@RequestMapping(value={"/edit"}, method={RequestMethod.GET})
	public String edit(String id, ModelMap model) {
		model.addAttribute("role", this.roleService.find(id));
		//model.addAttribute("authorities", this.roleService);
		return "/admin/system_set/role/role_edit";
	}	
	
}
