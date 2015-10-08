package com.njby.entity.search;

import java.io.Serializable;

public class SearchProduct implements Serializable{

	private static final long serialVersionUID = 7265885221017585103L;

	private String name;

	private String productTypeId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	
	
}
