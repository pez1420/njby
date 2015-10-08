package com.njby.entity.search;

import java.io.Serializable;


/**
 * 管理员搜索条件
 */
public class SearchAdmin implements Serializable{
	private static final long serialVersionUID = 6982141845761947180L;
	
	private String username;
	private String email;
	
	public SearchAdmin() {
		
	}
	
	public SearchAdmin(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
