package com.njby.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;


@EntityInfo("管理员")
public class Admin extends BaseEntity{
	private static final long serialVersionUID = -6444181652671408529L;

	@Meaning("用户名")
	private String username;
	@Meaning("密码")
	private String password;
	@Meaning("邮箱")
	private String email;
	@Meaning("是否启用")
	private Boolean isEnabled;
	@Meaning("登陆日期")
	private Date loginDate;
	@Meaning("最后登陆IP")
	private String loginIp;
	
	@Meaning("是否锁住")
	private Boolean isLocked;
	@Meaning("登录失败次数")
	private Integer loginFailureCount;
	@Meaning("锁住日期")
	private Date lockedDate;
	
	@Meaning("角色")
	private List<Role> roles = new ArrayList<Role>();
	

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }    
 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	
	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}
