package com.njby.entity.search;

import java.io.Serializable;

public class SearchEquipment implements Serializable{

	private static final long serialVersionUID = 3206975818858930699L;
	
	private String name;
	
	public SearchEquipment() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
