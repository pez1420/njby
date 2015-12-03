package com.njby.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Role;
import com.njby.entity.search.SearchRole;
import com.njby.service.RoleService;
import com.njby.utils.Message;
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
		Role role = this.roleService.find(id);
		model.addAttribute("role", role);
		model.addAttribute("authorities", this.roleService.findAuthorities(role));
		
		return "/admin/system_set/role/role_edit";
	}
	
	@RequestMapping(value={"/update"}, method={ RequestMethod.POST })
	public String update(Role role, HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		//检查数据库是否存在该角色
		Role dbRole = (Role)this.roleService.find(role.getId());
		if (dbRole == null || dbRole.getIsSystem().booleanValue()) 
			return "/admin/common/error";
		
		String[] authorities = request.getParameterValues("authorities");
		role.setIsSystem(Boolean.valueOf(false));
		this.roleService.update(role, authorities);
		
		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}
	
	@RequestMapping(value={"/delete"}, method={RequestMethod.POST})
	@ResponseBody
	public Message delete(String[] ids) {
		String a= "11";
		if (ArrayUtils.isNotEmpty(ids)) {
			
			for (String id : ids) {
				Role role = (Role)this.roleService.find(id);
				if (role != null && (role.getIsSystem().booleanValue() 
						|| this.roleService.countRoleAdmins(id))) {
					//如果为超级管理员或者是还存在跟该角色关联的用户
					return Message.error("admin.role.deleteExistNotAllowed", 
								new Object[] { role.getName() });
				}
			}
			
			//删除
			this.roleService.remove(ids);
			
		}
		
		return success;
	}
	
	
	
}
