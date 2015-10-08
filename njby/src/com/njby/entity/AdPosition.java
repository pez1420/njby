package com.njby.entity;

import java.util.ArrayList;
import java.util.List;

import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;


@EntityInfo("广告位")
public class AdPosition extends BaseEntity{

	private static final long serialVersionUID = 5122164886675254987L;
	
	@Meaning("名称")
	private String name;
	@Meaning("宽度")
	private Integer width;
	@Meaning("高度")
	private Integer height;
	@Meaning("描述")
	private String description;
	@Meaning("模板")
	private String template;
	
	List<Ad> ads = new ArrayList<Ad>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}
	
	
	
}
