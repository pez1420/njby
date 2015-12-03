package com.njby.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.RoleDao;
import com.njby.entity.Role;
import com.njby.entity.RoleAuthority;
import com.njby.entity.search.SearchRole;
import com.njby.service.RoleService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> 
	implements RoleService{
		
	@Resource
	private RoleDao roleDao;
	
	@Resource
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void update(Role role, String... authorities) {
		this.roleDao.update(role);
		
		List<RoleAuthority> pageRoleAuthorities = new ArrayList<RoleAuthority>();
		List<RoleAuthority> dbRoleAuthorities = this.roleDao.findRoleAuthorities(role);
		
		if (ArrayUtils.isNotEmpty(authorities)) {
			for (String authority : authorities) {
					RoleAuthority ra = new RoleAuthority();
					ra.setRoleId(role.getId());
					ra.setAuthorities(authority);
					pageRoleAuthorities.add(ra);
			}
		}
		
		if (dbRoleAuthorities == null) {
			dbRoleAuthorities = new ArrayList<RoleAuthority>();
		}
		
		Collection<RoleAuthority> subtract = CollectionUtils.subtract(dbRoleAuthorities, pageRoleAuthorities); 
		Iterator<RoleAuthority> it = subtract.iterator();
		while (it.hasNext()) {
			this.roleDao.deleteRoleAuthorities(it.next());
		}

		subtract = CollectionUtils.subtract(pageRoleAuthorities, dbRoleAuthorities); 
		it = subtract.iterator();
		while (it.hasNext()) {
			this.roleDao.saveRoleAuthorities(it.next());
		}
		
//		Collection<RoleAuthority> subtract = CollectionUtils.subtract(dbRoleAuthorities, pageRoleAuthorities); 	
//		if (!CollectionUtils.isEmpty(dbRoleAuthorities)) {
//			 for (RoleAuthority ra : dbRoleAuthorities) {
//				 System.out.println(ra.getAuthorities());
//			 }
//		}
		 
	}

	@Transactional(readOnly = true)
	public Page<Role> findPage(Pageable pageable, SearchRole searchRole) {
		// 分页并计算出总页数
		List<Role> roles = roleDao.findPage(pageable, searchRole);
		Page<Role> page = new Page<Role>(roles, pageable);
		return page;
	}

	@Transactional
	public void save(Role role, String... authorities) {
		this.roleDao.save(role);
		if (authorities != null) {
			for (String authority : authorities) {
					RoleAuthority roleAuthority = new RoleAuthority();
					roleAuthority.setRoleId(role.getId());
					roleAuthority.setAuthorities(authority);
					this.roleDao.saveRoleAuthorities(roleAuthority);
			}
		}
	}

	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return this.roleDao.findAll();
	}

	@Transactional(readOnly = true)
	public List<Role> findRolesByIds(String[] ids) {
		return this.roleDao.findRolesByIds(ids);
	}

	@Transactional(readOnly = true)
	public List<RoleAuthority> findRoleAuthorities(Role role) {
		return this.roleDao.findRoleAuthorities(role);
	}

	@Transactional(readOnly = true)
	public List<String> findAuthorities(Role role) {
		List<String> authorities = new ArrayList<String>();
		List<RoleAuthority> roleAuthorities = this.roleDao.findRoleAuthorities(role);
		if (roleAuthorities != null && !roleAuthorities.isEmpty()) {
			Iterator<RoleAuthority> it = roleAuthorities.iterator();
			while (it.hasNext()) {
				RoleAuthority roleAuthority = it.next();
				authorities.add(roleAuthority.getAuthorities());
			}
		}
		
		return authorities;
	}

	@Transactional(readOnly = true)
	public boolean countRoleAdmins(String id) {
		if (id == null) {
			return false;
		}
		
		long num = this.roleDao.countRoleAdmins(id);
		return num > 0L;
	}
	
	@Transactional
	//@CacheEvict(value={"authorization"}, allEntries=true)
	public void remove(String id) {
		//先刪除RoleAuthority
		RoleAuthority roleAuthority = new RoleAuthority();
		roleAuthority.setRoleId(id);
		this.roleDao.deleteRoleAuthorities(roleAuthority);
		//再删除角色
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
}