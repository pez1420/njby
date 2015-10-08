package com.njby.entity.search;

import java.io.Serializable;

public class SearchLog implements Serializable{
	private static final long serialVersionUID = 566162357784192379L;
	
	private String operation;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
