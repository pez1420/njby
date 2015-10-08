package com.njby.entity.search;

import java.io.Serializable;

public class SearchNavigation implements Serializable{
	private static final long serialVersionUID = -8033174494482935996L;
	
	private String name;
	
	private Integer position;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
	
}
