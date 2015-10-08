package com.njby.entity;


import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;

@EntityInfo("导航管理")
public class Navigation extends OrderEntity{
	private static final long serialVersionUID = -303646243521890887L;
	
	public enum Position {
	    top,  middle,  bottom;
	}  
	
	@Meaning("名称")
	private String name;
	@Meaning("位置")
	private Integer position;
	@Meaning("连接地址")
	private String url;
	@Meaning("是否新窗口打开")
	private Boolean isBlankTarget;
	 
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Boolean getIsBlankTarget() {
		return isBlankTarget;
	}
	
	public void setIsBlankTarget(Boolean isBlankTarget) {
		this.isBlankTarget = isBlankTarget;
	}
	
}
