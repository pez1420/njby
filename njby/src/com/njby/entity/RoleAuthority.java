package com.njby.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.system.ananotation.EntityInfo;


@EntityInfo("角色资源")
public class RoleAuthority implements Serializable{
	private static final long serialVersionUID = -8905507146116464593L;

	private String roleId;
	
	private String authorities;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	
	  @Override
	    public int hashCode() {
	        HashCodeBuilder builder = new HashCodeBuilder(17, 29);
	        builder.append(this.getRoleId());
	        builder.append(this.getAuthorities());
	        return builder.toHashCode();
	    }
	  
	    @Override
	    public boolean equals(final Object obj) {
	        if (obj == this) {
	            return true;
	        }
	        if (!(obj instanceof RoleAuthority)) {
	            return false;
	        }
	        RoleAuthority other = (RoleAuthority) obj;
	        EqualsBuilder builder = new EqualsBuilder();
	        builder.append(this.getRoleId(), other.getRoleId());
	        builder.append(this.getAuthorities(), other.getAuthorities());
	        return builder.isEquals();
	    }
}
