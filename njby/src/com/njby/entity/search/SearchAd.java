package com.njby.entity.search;

import java.io.Serializable;

public class SearchAd implements Serializable{
	private static final long serialVersionUID = 641074383374021952L;
	
	private String title;
	
	public SearchAd() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
