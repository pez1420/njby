package com.njby.entity;

import java.util.ArrayList;
import java.util.List;

import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;



@EntityInfo("角色")
public class Role extends BaseEntity{
	private static final long serialVersionUID = -7766126243533383775L;
	
	@Meaning("描述")
    private String description;
	@Meaning("是否系统管理员")
    private Boolean isSystem;
	@Meaning("角色名称")
    private String name;
	
	@Meaning("管理员")
    List<Admin> admins = new ArrayList<Admin>();
	@Meaning("角色权限")
	List<RoleAuthorities> roleAuthorities = new ArrayList<RoleAuthorities>();
	
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Boolean isSystem) {
        this.isSystem = isSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	
	public List<RoleAuthorities> getRoleAuthorities() {
		return roleAuthorities;
	}

	public void setRoleAuthorities(List<RoleAuthorities> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}

	public String toString(){
		return name;	
	}
	
}
