package com.njby.entity.search;

import java.io.Serializable;

public class SearchProductType implements Serializable{

	private static final long serialVersionUID = -103045417769566030L;
	
	private String username;
	
	public SearchProductType() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
