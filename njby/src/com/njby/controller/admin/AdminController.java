package com.njby.controller.admin;

import java.util.List;

import javax.annotation.Resource;


//import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Admin;
import com.njby.entity.Role;
import com.njby.entity.search.SearchAdmin;
import com.njby.service.AdminService;
import com.njby.service.RoleService;
import com.njby.utils.Message;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


@Controller("adminAdminController")
@RequestMapping({ "/admin/admin" })
public class AdminController extends BaseAdminController {

	@Resource
	private AdminService adminService;

	@Resource
	private RoleService roleService;

	@RequestMapping(value = { "/check_username" }, method = { RequestMethod.GET })
	@ResponseBody
	public boolean checkUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return false;
		}
		return !this.adminService.usernameExists(username);
	}

	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
	public String list(Pageable pageable, SearchAdmin searchAdmin,
			ModelMap model) {
		model.addAttribute("page", adminService.findPage(pageable, searchAdmin));
		model.addAttribute("search", searchAdmin);
		
		return "/admin/system_set/admin/admin_view";
	}

	@RequestMapping(value = { "/add" }, method = { RequestMethod.GET })
	public String add(ModelMap model) {
		model.addAttribute("roles", this.roleService.findAll());
		
		return "/admin/system_set/admin/admin_add";
	}

	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public String save(Admin admin, String[] roleIds,
			RedirectAttributes redirectAttributes) {
		List<Role> roles = roleService.findRolesByIds(roleIds);
		admin.setRoles(roles);
		// adminer.setPassword(adminer.getPaswword()); //5加密
		admin.setIsLocked(Boolean.valueOf(false));
		admin.setLoginFailureCount(Integer.valueOf(0));
		admin.setLockedDate(null);
		admin.setLoginDate(null);
		admin.setLoginIp(null);

		this.adminService.save(admin);

		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}

	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		model.addAttribute("admin", this.adminService.findAdminRoles(id));
		model.addAttribute("roles", this.roleService.findAll());
		
		return "/admin/system_set/admin/admin_edit";
	}

	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public String update(Admin admin, String[] roleIds,
			RedirectAttributes redirectAttributes) {
		// 设置当前用户角色
		admin.setRoles(roleService.findRolesByIds(roleIds));
		Admin existAdmin = this.adminService.find(admin.getId());

		if (existAdmin == null) {
			return "/admin/common/error";
		}
		if (StringUtils.isNotEmpty(admin.getPassword())) {
			admin.setPassword(admin.getPassword());
		} else {
			admin.setPassword(existAdmin.getPassword());
		}

		if (existAdmin.getIsLocked().booleanValue()
				&& !admin.getIsLocked().booleanValue()) {
			admin.setLoginFailureCount(Integer.valueOf(0));
			admin.setLockedDate(null);
		} else {
			admin.setIsLocked(existAdmin.getIsLocked());
			admin.setLoginFailureCount(existAdmin.getLoginFailureCount());
			admin.setLockedDate(existAdmin.getLockedDate());
		}

		this.adminService.updateWithRole(admin);

		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";
	}
	
	@RequestMapping(value={"/delete"}, method={RequestMethod.POST})
	@ResponseBody
	public Message delete(String[] ids) {
		if (ids.length >= this.adminService.count())
			return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);
		
		this.adminService.remove(ids);
		return success;
	}

}
