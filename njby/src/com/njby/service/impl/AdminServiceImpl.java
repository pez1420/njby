package com.njby.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.Principal;
import com.njby.dao.AdminDao;
import com.njby.entity.Admin;
import com.njby.entity.AdminRoleLink;
import com.njby.entity.Role;
import com.njby.entity.search.SearchAdmin;
import com.njby.service.AdminService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, String> implements
		AdminService {

	@Resource
	private AdminDao adminDao;

	@Resource
	public void setBaseDao(AdminDao adminDao) {
		super.setBaseDao(adminDao);
	}

	@Transactional
	//@CacheEvict(value={"authorization"}, allEntries=true)
	public void save(Admin admin) {
		super.save(admin);
		List<Role> roles = admin.getRoles();
		if (roles != null && !roles.isEmpty()) {
			AdminRoleLink adminRoleLink = new AdminRoleLink();
			adminRoleLink.setAdmin(admin);
			for (Role role : roles) {
				adminRoleLink.setRole(role);
				this.adminDao.saveRelativity(adminRoleLink);
			}
		}
	}

	@Transactional
	//@CacheEvict(value={"authorization"}, allEntries=true)
	public void remove(String id) {
		Admin admin = new Admin();
		admin.setId(id);
		AdminRoleLink adminRoleLink = new AdminRoleLink();
		adminRoleLink.setAdmin(admin);
		// 先删除AdminRoleLink关联关系
		this.adminDao.removeRelativity(adminRoleLink);
		// 再删除Admin记录
		super.remove(id);
	}

	@Transactional
	//@CacheEvict(value={"authorization"}, allEntries=true)
	public void remove(String... ids) {
		if (ids != null) {
			for (String id : ids) {
				this.remove(id);
			}
		}
	}

	@Transactional(readOnly = true)
	public Page<Admin> findPage(Pageable pageable, SearchAdmin searchAdmin) {
		// 分页并计算出总页数
		List<Admin> admins = adminDao.findPage(pageable, searchAdmin);
		Page<Admin> page = new Page<Admin>(admins, pageable);
		System.out.println("数据库中查询admin分页数据");
		return page;
	}

	@Transactional(readOnly = true)
	public boolean usernameExists(String username) {
		if (username == null) {
			return false;
		}
		long num = adminDao.usernameExists(username);
		return num > 0L;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	//@CacheEvict(value={"authorization"}, allEntries=true)
	public void updateWithRole(Admin admin) {
		/***
		 * 
		 * 更新用户(包含用户角色)
		 * 
		 * 首先返回当前admin数据库角色列表 其次确定新增和被删除的角色信息
		 * 
		 */
		super.update(admin);

		Admin adminWithRoles = this.adminDao.findAdminRoles(admin.getId());
		// 返回原来用户与角色的所有关系
		List<Role> pageRoles = admin.getRoles();
		List<Role> dbRoles = adminWithRoles.getRoles();
		if (dbRoles == null) {
			dbRoles = new ArrayList<Role>();
		}

		// 先delete 再insert
		AdminRoleLink adminRoleLink = new AdminRoleLink();
		Collection<Role> subtract = CollectionUtils
				.subtract(dbRoles, pageRoles);
		Iterator<Role> it = subtract.iterator();
		while (it.hasNext()) {
			Role role = it.next();
			adminRoleLink.setAdmin(admin);
			adminRoleLink.setRole(role);
			this.adminDao.removeRelativity(adminRoleLink);
		}

		subtract = CollectionUtils.subtract(pageRoles, dbRoles);
		it = subtract.iterator();
		while (it.hasNext()) {
			Role role = it.next();
			adminRoleLink.setAdmin(admin);
			adminRoleLink.setRole(role);
			this.adminDao.saveRelativity(adminRoleLink);
		}

	}

	@Transactional(readOnly = true)
	public List<String> findAuthorities(String id) {
		return this.adminDao.findAuthorities(id);
	}

	@Transactional(readOnly = true)
	public boolean isAuthenticated() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			return subject.isAuthenticated();
		}
		return false;
	}

	@Transactional(readOnly = true)
	public Admin getCurrent() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return (Admin) this.adminDao.find(principal.getId());
			}
		}
		return null;
	}

	@Transactional(readOnly = true)
	public String getCurrentUsername() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return principal.getUsername();
			}
		}
		return null;
	}

	@Transactional(readOnly = true)
	public Admin findByUsername(String username) {
		return this.adminDao.findByUsername(username);
	}

	@Transactional(readOnly = true)
	public Admin findAdminRoles(String id) {
		// TODO Auto-generated method stub
		return this.adminDao.findAdminRoles(id);
	}

}

