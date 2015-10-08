package com.njby.entity.search;

import java.io.Serializable;

/**
 * @pez1420 pez1420(pez1420@163.com)
 * @date 2015-10-05
 */
public class SearchCulture implements Serializable {

	private static final long serialVersionUID = -1469747511053501582L;
	
	private String title;
	
	
	public SearchCulture() {
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
	
}