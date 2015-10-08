package com.njby.entity;

import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;


@EntityInfo("角色权限")
public class RoleAuthorities extends BaseEntity{
	private static final long serialVersionUID = -9042963865520520833L;
	
	@Meaning("权限")
	private String authorities;
	@Meaning("角色")
	private Role role;
	
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
