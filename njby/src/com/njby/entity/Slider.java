package com.njby.entity;

import com.system.ananotation.EntityInfo;


@EntityInfo("幻灯片")
public class Slider extends BaseEntity{

	private static final long serialVersionUID = 3153586761491012122L;
	
	private String title;
	
	private String image;
	
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
